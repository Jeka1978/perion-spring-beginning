package com.perion.real_spring.spring_patterns.never_use_switch;

import lombok.SneakyThrows;

/**
 * @author Evgeny Borisov
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        DistributionService service = new DistributionService();
        MessageProducer messageProducer = new MessageProducer();
        while (true) {// todo should be scheduled with spring
            service.distribute(messageProducer.generate());
            Thread.sleep(1000);
        }
    }
}
