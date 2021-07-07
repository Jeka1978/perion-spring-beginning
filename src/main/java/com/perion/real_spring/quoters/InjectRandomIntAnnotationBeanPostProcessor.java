package com.perion.real_spring.quoters;

import com.perion.my_spring.InjectRandomIntAnnotationSupportObjectConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Evgeny Borisov
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    private InjectRandomIntAnnotationSupportObjectConfigurator configurator = new InjectRandomIntAnnotationSupportObjectConfigurator();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        configurator.configure(bean);
        return bean;
    }
}
