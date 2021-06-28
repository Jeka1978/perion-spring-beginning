package com.perion.my_spring;

/**
 * @author Evgeny Borisov
 */
public class IRobot {

    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public void cleanRoom() {
        speaker.speak("I started to clean");
        cleaner.clean();
        speaker.speak("I finished to clean");
    }

}
