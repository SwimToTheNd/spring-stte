package com.stte.spring.annoconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 普通的类，使用@Import注册到Spring容器中
 * create by BloodFly at 2020/7/29
 */
public class Color implements InitializingBean, ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware, ResourceLoaderAware {

    private ApplicationContext applicationContext;

    private String name;

    public Color() {
        System.out.println("constructor.....");
    }

    public void init() {
        System.out.println("init......");
    }

    public void destory() {
        System.out.println("destory......");
    }

    /**
     * 使用JSR250规范
     * 在Bean的构造方法完成后调用
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct......");
    }

    /**
     * JSR250注解，在容器移除Bean对象前调用
     */
    @PreDestroy
    public void preDestory() {
        System.out.println("preDestory......");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setter.......");
    }

    /**
     * ApplicationContextAware获取Spring底层的对象ApplicationContext
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("get applicationContext:" + applicationContext);
        this.applicationContext = applicationContext;
    }

    /**
     * BeanNameAware获得当前Bean在Spring IOC容器中的名字
     *
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println("Bean Name is: " + s);
    }

    /**
     * StringValueResolver可以解析一些字符串表达式，如Spel表达，${}、#{}表达式
     *
     * @param stringValueResolver
     * @return
     */
    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String r = stringValueResolver.resolveStringValue("Environment os.name: ${os.name},Spel result:#{20 * 12}");
        System.out.println("stringValueResolver:" + r);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("resourceLoader: " + resourceLoader);
    }
}
