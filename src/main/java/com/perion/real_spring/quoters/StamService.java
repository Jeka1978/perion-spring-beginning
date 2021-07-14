package com.perion.real_spring.quoters;

import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class StamService {

    public void saySomething(String s) {
        System.out.println(s);
    }
}
