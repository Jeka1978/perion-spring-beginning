package com.perion.real_spring.spring_patterns.never_use_switch;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
@Component
public class MessageProducer {

    @Autowired
    private Faker faker;
    @Autowired
    private Random random;
    @Autowired
    private DistributionService distributionService;

    private List<String> types = asList("sms", "whatsapp","fax");




    @Scheduled(fixedDelay = 1000)
    public void generate() {
        Message message = Message.builder().text(faker.chuckNorris().fact())
                .distributionType(types.get(random.nextInt(types.size())))
                .build();
        distributionService.distribute(message);
    }
}











