package com.perion.aop_lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class PerionService1Impl implements PerionService1 {
    @Autowired
    private Perion2Service perion2Service;

    @Override
    public void doWork() {
        System.out.println("work1");
        perion2Service.doStuff();
    }
}
