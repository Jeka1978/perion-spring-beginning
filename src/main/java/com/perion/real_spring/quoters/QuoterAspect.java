package com.perion.real_spring.quoters;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Aspect
@Component
public class QuoterAspect {


    @Before("execution(* com.perion..*.say*(..))")
//    @Before("@annotation(Deprecated)")
    public void beforeSayMethods(JoinPoint jp) {
        String simpleName = jp.getTarget().getClass().getSimpleName();
        System.out.print("This is quote of " + simpleName + ": ");
    }


    @SneakyThrows
    @Around("@annotation(Secured)")
    public Object doSecured(ProceedingJoinPoint pjp) {
        Random random = new Random();
        int i = random.nextInt(3);
        if (i == 1) {
            throw new SecurityException("not allowed here, try again later");
        }
        Object retVal = pjp.proceed();

        System.out.println("method was invoked succ " + pjp.getSignature().getName());
        return retVal;
    }


}



