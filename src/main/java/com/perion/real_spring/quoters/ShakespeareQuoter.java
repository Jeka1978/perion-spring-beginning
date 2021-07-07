package com.perion.real_spring.quoters;

import com.perion.my_spring.InjectRandomInt;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Book
public class ShakespeareQuoter implements Quoter {
    @Setter
    @Value("${shake}")
    private String message;

    @InjectRandomInt(min = 3,max = 7)
    private int repeat;

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
