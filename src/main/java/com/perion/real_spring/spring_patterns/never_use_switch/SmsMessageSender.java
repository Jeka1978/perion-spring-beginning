package com.perion.real_spring.spring_patterns.never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class SmsMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println(message+" was sent by sms");
    }

    @Override
    public String myType() {
        return SMS;
    }
}
