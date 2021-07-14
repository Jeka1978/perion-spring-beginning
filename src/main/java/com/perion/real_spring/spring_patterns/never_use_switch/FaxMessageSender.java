package com.perion.real_spring.spring_patterns.never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component("fax")
public class FaxMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println("SENT BY FAX");
    }
}
