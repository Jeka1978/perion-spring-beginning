package com.perion.my_junit;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        TestRunner runner = new TestRunner();

        Person person = Person.builder().age(12).name("Eldad").build();

//        runner.printMetadata(person);
//        runner.runAllTestsMethods(person);
        runner.runAllTestsMethods("com.perion.my_junit.Person");
    }
}
