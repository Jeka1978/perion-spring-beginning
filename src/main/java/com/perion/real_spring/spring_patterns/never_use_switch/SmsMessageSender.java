package com.perion.real_spring.spring_patterns.never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component("sms")
public class SmsMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println(message+" was sent by sms");
    }
}
