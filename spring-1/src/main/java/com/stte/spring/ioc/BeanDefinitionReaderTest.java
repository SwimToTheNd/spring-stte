package com.stte.spring.ioc;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.Arrays;

/**
 * BeanDefinitionReader装载过程
 * create by BloodFly at 2020/7/3
 */
public class BeanDefinitionReaderTest {

    public static void main(String[] args) {
        // 1 BeanDefinition的注册中心
        BeanDefinitionRegistry beanDefinitionRegistry = new SimpleBeanDefinitionRegistry();
        // 2 Bean定义装载器
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
        // 3 资源加载器
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        // 4 加载资源
        Resource resource = resourceLoader.getResource("spring-beans.xml");
        // 5 装载Bean定义
        beanDefinitionReader.loadBeanDefinitions(resource);

        System.out.println(Arrays.toString(beanDefinitionRegistry.getBeanDefinitionNames()));
        System.out.println(beanDefinitionRegistry.getBeanDefinition("cart"));
//        ResourcePatternResolver  resolver = new PathMatchingResourcePatternResolver();
//        resolver.getResources("classpath*");

    }
}
