package com.perion.my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class InjectRandomIntAnnotationSupportObjectConfigurator implements ObjectConfigurator {
    private Random random = new Random();

    @SneakyThrows
    @Override
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();

                int randomValue = random.nextInt(max - min) + min + 1;
                field.setAccessible(true);
                field.set(t, randomValue);
            }
        }

    }
}
