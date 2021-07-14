package com.perion.real_spring.spring_patterns.never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * @author Evgeny Borisov
 */

@Service
public class DistributionService {

    private Map<String, MessageSender> senderMap;


    @Autowired
    public void initSenderMap(List<MessageSender> senders) {
        senderMap = senders.stream().collect(toMap(MessageSender::myType, identity()));
    }


    public void distribute(Message message) {
        MessageSender sender = senderMap.get(message.getDistributionType());
        if (sender == null) {
            throw new UnsupportedOperationException(message.getDistributionType() + " not supported yet");
        }
        sender.send(message);
    }

}
