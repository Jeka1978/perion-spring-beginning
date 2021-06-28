package com.perion.my_spring;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {

//        new ApplicationContext().getObject(IRobot.class).cleanRoom();

        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
    }
}
