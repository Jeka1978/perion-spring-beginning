package com.perion.real_spring.spring_profiles_example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
public class MainConfig {

    @Bean
    public Random random(){
        return new Random();
    }






    public static void main(String[] args) {
//        System.getenv().put("spring.profiles.active", "RUSS");

        new AnnotationConfigApplicationContext(MainConfig.class);
    }
}
