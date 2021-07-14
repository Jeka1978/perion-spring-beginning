package com.perion.real_spring.spring_patterns.never_use_switch;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
@EnableScheduling
public class Main {



    @Bean
    public Random random(){
        return new Random();
    }

    @Bean
    public Faker faker(){
        return new Faker();
    }

    @SneakyThrows
    public static void main(String[] args) {

     new AnnotationConfigApplicationContext(Main.class);

    }
}
