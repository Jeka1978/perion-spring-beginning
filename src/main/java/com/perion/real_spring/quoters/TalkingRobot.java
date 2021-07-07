package com.perion.real_spring.quoters;

import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class TalkingRobot {

    private int version;

    public TalkingRobot(int version) {
        this.version = version;
    }

    @Setter
    private List<Quoter> quoters;



    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }

}
