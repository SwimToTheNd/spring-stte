package com.stte.spring.annoconfig.ext;

import com.stte.spring.annoconfig.Yellow;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanDefinitionRegistryPostProcessor BeanDefinition注册中心后置处理器
 * 在BeanFactory初始化后，BeanFactoryPostProcessor BeanFactory后置处理器之前执行
 * <p>
 * <p>
 * create by BloodFly at 2020/8/3
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        int beanDefinitionCount = registry.getBeanDefinitionCount();
        System.out.println("postProcessBeanDefinitionRegistry...含有BeanDefinition个数 ：" + beanDefinitionCount);
        //注册一个BeanDefiniton
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Yellow.class).getBeanDefinition();
        registry.registerBeanDefinition("hello", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        System.out.println("postProcessBeanFactory...含有BeanDefinition个数 ：" + beanDefinitionCount);
    }
}
