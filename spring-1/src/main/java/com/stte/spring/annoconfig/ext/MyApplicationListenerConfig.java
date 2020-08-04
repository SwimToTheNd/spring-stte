package com.stte.spring.annoconfig.ext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * create by BloodFly at 2020/8/4
 */
@ComponentScan(basePackages = "com.stte.spring.annoconfig.ext",
        excludeFilters = {
                @ComponentScan.Filter(value = {ComponentScan.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {MyBeanFactoryPostProcessor.class, MyBeanDefinitionRegistryPostProcessor.class})
        })
@Configuration
public class MyApplicationListenerConfig {
}
