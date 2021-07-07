package com.perion.real_spring.spring_patterns.never_use_switch;

/**
 * @author Evgeny Borisov
 */

public class DistributionService {

    //todo refactor all this project
    //todo 1 add spring
    //todo never use switch, so distribute method should be refactored

    public void distribute(Message message) {

        if (message.getDistributionType().equalsIgnoreCase("sms")) {
            // 40 lines of code which send sms
            System.out.println("msg type was: "+message.getDistributionType());
            System.out.println("sms was sent "+message.getText());
        }else {
            // 30 lines of code to send mail
            System.out.println("msg type was: "+message.getDistributionType());
            System.out.println("mail was sent "+message.getText());
        }

    }

}
