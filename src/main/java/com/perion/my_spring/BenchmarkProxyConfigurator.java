package com.perion.my_spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Evgeny Borisov
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class<?> originalClass) {
        if (originalClass.isAnnotationPresent(Benchmark.class) || Arrays.stream(originalClass.getMethods()).anyMatch(method -> method.isAnnotationPresent(Benchmark.class))) {
            return Proxy.newProxyInstance(originalClass.getClassLoader(), originalClass.getInterfaces(), (proxy, method, args) -> {
                Method originalMethod = originalClass.getMethod(method.getName(), method.getParameterTypes());
                if (originalClass.isAnnotationPresent(Benchmark.class)|| originalMethod.isAnnotationPresent(Benchmark.class)) {
                    System.out.println("*********BENCHAMRK STARTED FOR METHOD " + method.getName() + " ****************");
                    long start = System.nanoTime();
                    Object retVal = method.invoke(t, args);
                    long end = System.nanoTime();
                    System.out.println(end - start);
                    System.out.println("*********BENCHAMRK ENDED FOR METHOD " + method.getName() + " ****************");
                    return retVal;
                }else {
                    return method.invoke(t, args);
                }
            });
        }

        return t;

    }
}
