package com.perion.refresh_prototype_in_singleton;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
//@ImportResource("classpath:context.xml")
public class ScreenSaverConf {


    @Bean
    @Scope("prototype")
    public Color color(){
        return new Color(random().nextInt(255), random().nextInt(255), random().nextInt(255));
    }


    @Bean
    public Random random(){
        return new Random();
    }









    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScreenSaverConf.class);
        while (true) {
            ColorFrame colorFrame = context.getBean(ColorFrame.class);
            colorFrame.moveToRandomLocation();
            Thread.sleep(50);
        }
    }
}
