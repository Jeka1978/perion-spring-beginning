package com.perion.aop_lab;

import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class Perion2Service {
    public void doStuff(){
        System.out.println("doing stuff...");
        throw new DBRuntimeException("fire all DBA!");
    }
}
