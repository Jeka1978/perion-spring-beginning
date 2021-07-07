package com.perion.real_spring.spring_patterns.never_use_switch;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
public class MessageProducer {

    private Faker faker = new Faker();
    private Random random = new Random();

    private List<String> types = asList("sms", "mail","whatsapp");
    public Message generate() {
        return Message.builder().text(faker.chuckNorris().fact())
                .distributionType(types.get(random.nextInt(types.size())))
                .build();
    }
}











