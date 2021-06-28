package com.perion.my_spring;

import lombok.Data;

/**
 * @author Evgeny Borisov
 */

@Data
public class Hobbit {

    @InjectRandomInt(min=3,max =7)
    private int power;
    @InjectRandomInt(min=15,max =22)
    private int speed;
}
