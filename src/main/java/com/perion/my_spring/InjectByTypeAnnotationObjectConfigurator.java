package com.perion.my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @SneakyThrows
    @Override
    public void configure(Object t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {

                //context.getObject(field.getType())
                Object object = ObjectFactory.getInstance().createObject(field.getType());
                field.setAccessible(true);
                field.set(t,object);
            }
        }
    }
}
