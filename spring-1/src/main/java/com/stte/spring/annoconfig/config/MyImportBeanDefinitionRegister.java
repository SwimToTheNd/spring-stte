package com.stte.spring.annoconfig.config;

import com.stte.spring.annoconfig.Rainbow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 通过ImportBeanDefinitionRegister接口，可以自己声明BeanDefinition并注册到Spring容器中
 * create by BloodFly at 2020/7/29
 */
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    /**
     * annotationMetadata:@Import注解所在类的所有注解元信息
     * beanDefinitionRegistry：容器的注册中心，将BeanDefinition注册进来
     *
     * @param annotationMetadata
     * @param beanDefinitionRegistry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean containsRed = beanDefinitionRegistry.containsBeanDefinition("com.stte.spring.annoconfig.Red");
        boolean containsBlue = beanDefinitionRegistry.containsBeanDefinition("com.stte.spring.annoconfig.Blue");
        if (containsRed && containsBlue) {
            BeanDefinition beanDefinition = new RootBeanDefinition(Rainbow.class);
            beanDefinitionRegistry.registerBeanDefinition("rainbow", beanDefinition);
        }
    }
}
