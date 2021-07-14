package com.perion.real_spring.spring_patterns.never_use_switch;

/**
 * @author Evgeny Borisov
 */
public interface MessageSender {

    String WHATSAPP = "whatsapp";
    String SMS = "sms";
    String FAX = "fax";


    void send(Message message);

    String myType();
}
