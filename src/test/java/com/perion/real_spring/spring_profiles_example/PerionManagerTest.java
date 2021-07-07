package com.perion.real_spring.spring_profiles_example;

import com.perion.real_spring.qualifiers_example.MainConf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MainConfig.class)
@ActiveProfiles("ENG")
public class PerionManagerTest {

    @Autowired
    private PerionManager perionManager;


    @Test
    public void doWork() {
        System.out.println(123);
        perionManager.doWork();
    }
}