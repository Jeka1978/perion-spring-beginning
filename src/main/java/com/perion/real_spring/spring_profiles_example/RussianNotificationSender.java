package com.perion.real_spring.spring_profiles_example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
@Profile("RUSS")
public class RussianNotificationSender implements NotificationSender {

    @Override
    public void sendAlert() {
        System.out.println("Подъём тревога!!!");
    }

}
