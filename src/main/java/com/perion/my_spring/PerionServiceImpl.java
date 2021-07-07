package com.perion.my_spring;

/**
 * @author Evgeny Borisov
 */
public class PerionServiceImpl implements PerionService {
    @Override
    @Benchmark
    public void drinkBeer() {
        System.out.println("Leff is not so good");
    }

    @Override
    public void doWork() {
        System.out.println("I love my work");
    }


    public static void main(String[] args) {
        PerionService service = ObjectFactory.getInstance().createObject(PerionService.class);
        service.doWork();
        service.drinkBeer();
    }
}





