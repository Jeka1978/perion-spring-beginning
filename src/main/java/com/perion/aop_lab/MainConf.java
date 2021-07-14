package com.perion.aop_lab;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
public class MainConf {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConf.class);
        try {
            context.getBean(PerionService1.class).doWork();
        } catch (Exception e) {
            System.out.println("Huston we have a problem");
        }
    }
}
