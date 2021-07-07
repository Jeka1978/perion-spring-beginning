package com.perion.my_spring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();


    private Reflections scanner = new Reflections("com.perion");


    @SneakyThrows
    public ObjectFactory() {
        fillConfigurators();
        fillProxyConfigurators();
    }

    private void fillProxyConfigurators() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Set<Class<? extends ProxyConfigurator>> classes = scanner.getSubTypesOf(ProxyConfigurator.class);
        for (Class<? extends ProxyConfigurator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                proxyConfigurators.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }

    private void fillConfigurators() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                configurators.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }

    public static ObjectFactory getInstance() {
        return instance;
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImpl(type);

        T t = create(type);

        configure(t);

        runInitMethods(type, t);

        t = wrapWithProxy(type, t);

        //todo support for @Benchmark above method
        // think about wrapping object factory with additional layer (ApplicationContext)
        //write @Singleton annotation and support ite


        return t;


    }

    private <T> T wrapWithProxy(Class<T> type, T t) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            t = (T) proxyConfigurator.replaceWithProxyIfNeeded(t, type);
        }
        return t;
    }

    private <T> void runInitMethods(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(configurator -> configurator.configure(t));
    }

    private <T> T create(Class<T> type) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        T t = type.getDeclaredConstructor().newInstance();
        return t;
    }


    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            Class<T> implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new RuntimeException("0 or more imp found for " + type);
                }
                implClass = (Class<T>) classes.iterator().next();
            }
            type = implClass;
        }
        return type;
    }


}
