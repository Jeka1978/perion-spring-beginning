package com.perion.refresh_prototype_in_singleton;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.concurrent.TimeUnit;

/**
 * @author Evgeny Borisov
 */
public class TwoSecondsScopeProvider implements Scope {

    Cache<String, Object> cache = CacheBuilder.newBuilder()
            .expireAfterAccess(2, TimeUnit.SECONDS)
//            .expireAfterWrite(2, TimeUnit.SECONDS)
            .weakKeys()
            .softValues()
            .build();

    @SneakyThrows
    @Override
    public Object get(String beanName, ObjectFactory<?> objectFactory) {

        return cache.get(beanName, objectFactory::getObject);


    }


    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
