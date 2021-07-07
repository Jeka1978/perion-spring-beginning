package com.perion.real_spring.quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;


/**
 * @author Evgeny Borisov
 */
@Component
public class TerminatorQuoter implements Quoter {


    private List<String> messages;


  /*  @Value("${JAVA_HOME2:abc}")
    public void printSomeProps(String javaHome,@Value("${M2_HOME}") String m2Home) {
        System.out.println("javaHome = " + javaHome);
        System.out.println("m2Home = " + m2Home);
    }*/


    @Value("${terminator_quotes}")
    public void setMessages(String[] messages) {
        this.messages = stream(messages).map(String::toUpperCase).collect(Collectors.toList());
    }

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }



    public void killAll(){
        System.out.println("You are terminated...");
    }

}















