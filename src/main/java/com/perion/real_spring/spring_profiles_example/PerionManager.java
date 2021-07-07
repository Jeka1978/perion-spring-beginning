package com.perion.real_spring.spring_profiles_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class PerionManager {

    @Autowired
    private NotificationSender sender;


    @EventListener(ContextRefreshedEvent.class)
    public void doWork() {
        System.out.println("Working....");
        sender.sendAlert();
    }
}





