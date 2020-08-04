package com.stte.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * create by BloodFly at 2020/6/7
 */
public class User implements InitializingBean, ApplicationContextAware, BeanFactoryAware, BeanNameAware {

    private String name;
    private String wifeName;
    private List<Car> cars;
    private Set<String> hobby;
    private Map<String, Service> services;
    private ApplicationContext applicationContext;

    public User() {
        System.out.println("user's constructor......");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setUserName:" + name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", wifeName='" + wifeName + '\'' +
                ", cars=" + cars +
                ", hobby=" + hobby +
                ", services=" + services +
                '}';
    }

    public String getWifeName() {
        return wifeName;
    }

    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Set<String> getHobby() {
        return hobby;
    }

    public void setHobby(Set<String> hobby) {
        this.hobby = hobby;
    }

    public Map<String, Service> getServices() {
        return services;
    }

    public void setServices(Map<String, Service> services) {
        this.services = services;
    }

    // bean的初始化方法
    public void init() {
        System.out.println("user's init......");
    }

    // bean的销毁方法
    public void destroy() {
        System.out.println("user's destroy......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet....");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("ApplicatonContextAware...");
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware..." + beanFactory);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware..." + s);
    }
}
