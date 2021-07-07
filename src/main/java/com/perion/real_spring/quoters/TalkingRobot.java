package com.perion.real_spring.quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
@Component
public class TalkingRobot {


    @Autowired
    private List<Quoter> quoters;


    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }

}
