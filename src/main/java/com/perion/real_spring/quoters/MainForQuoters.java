package com.perion.real_spring.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class MainForQuoters {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        System.out.println();
        context.close();
    }
}
