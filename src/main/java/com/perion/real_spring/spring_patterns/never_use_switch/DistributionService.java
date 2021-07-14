package com.perion.real_spring.spring_patterns.never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */

@Service
public class DistributionService {

    @Autowired
    private Map<String, MessageSender> senderMap;

    public void distribute(Message message) {
        MessageSender sender = senderMap.get(message.getDistributionType());
        if (sender == null) {
            throw new UnsupportedOperationException(message.getDistributionType() + " not supported yet");
        }
        sender.send(message);
    }

}
