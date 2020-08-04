package com.stte.spring.annoconfig.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

/**
 * 使用@Conditional需要，实现Condition接口
 * create by BloodFly at 2020/7/29
 */
public class WindowCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //根据条件上下文可以获取BeanFactory、类加载器、环境信息、Bean定义的注册中心、资源加载器
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();

        ClassLoader classLoader = conditionContext.getClassLoader();
        System.out.println("classLoader:" + classLoader);
        Environment environment = conditionContext.getEnvironment();
        System.out.println("environment:" + environment);
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        System.out.println("count:" + registry.getBeanDefinitionCount() + " benaDefinitionNames:" + Arrays.toString(registry.getBeanDefinitionNames()));
        ResourceLoader resourceLoader = conditionContext.getResourceLoader();
        System.out.println("resourceLoader:" + resourceLoader);

        //根据环境变量判断操作系统是否为windows
        String property = environment.getProperty("os.name");
        System.out.println("os.name:" + property);

        if (property.toLowerCase().contains("windows")) {
            return true;
        }
        return false;
    }
}
