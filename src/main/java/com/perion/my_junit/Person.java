package com.perion.my_junit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private  int age;





    public void test1(){
        System.out.println("11111111111");
    }

    public void test2(){
        System.out.println("22222222222");
    }


    public void notTest(){
        System.out.println("NNNNNNNNNNNNNNN");
    }












}
