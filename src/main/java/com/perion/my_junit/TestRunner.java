package com.perion.my_junit;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */
public class TestRunner {


    @SneakyThrows
    public void runAllTestsMethods(String className) {
        Class<?> clazz = Class.forName(className);
        runAllTestsMethods(clazz);
    }

    @SneakyThrows
    public void runAllTestsMethods(Class<?> type) {
        Object o = type.getDeclaredConstructor().newInstance();
        runAllTestsMethods(o);
    }

    @SneakyThrows
    public void runAllTestsMethods(Object o) {
        Method[] methods = o.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("test")) {
                method.invoke(o);
            }
        }
    }


    @SneakyThrows
    public void printMetadata(Object o) {
        Class<?> clazz = o.getClass();
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getParameterCount());
        }

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {

            System.out.println(declaredField.getName());
            System.out.println(declaredField.getType());
            declaredField.setAccessible(true);
            System.out.println(declaredField.get(o));
        }

    }
}
