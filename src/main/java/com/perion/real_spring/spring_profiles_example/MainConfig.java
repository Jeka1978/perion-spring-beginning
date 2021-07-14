package com.perion.real_spring.spring_profiles_example;

import com.perion.real_spring.quoters.Quoter;
import com.perion.real_spring.quoters.TerminatorQuoter;
import org.springframework.context.annotation.*;

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
