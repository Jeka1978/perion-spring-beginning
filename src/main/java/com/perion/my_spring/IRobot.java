package com.perion.my_spring;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
public class IRobot {


    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    @PostConstruct
    public void unit(){
        System.out.println(cleaner.getClass());
    }

    public void cleanRoom() {
        speaker.speak("I started to clean");
        cleaner.clean();
        speaker.speak("I finished to clean");
    }

}
