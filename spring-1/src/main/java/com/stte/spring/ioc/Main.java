package com.stte.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring支持3种依赖注入方式：属性注入、构造器注入、工厂方法注入
 *
 * create by BloodFly at 2020/6/7
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
        // 未使用id时候，默认使用类的全限定名作为id
        Car car2 = (Car) applicationContext.getBean("com.stte.spring.ioc.Car");
        System.out.println(car2);
        Car car3 = (Car) applicationContext.getBean("car3");
        System.out.println(car3);
        Car car4 = (Car) applicationContext.getBean("car4");
        System.out.println(car4);
        Car cart = (Car) applicationContext.getBean("cart");
        System.out.println(cart);

        // 使用ref装配容器中的bean
        Action action = (Action) applicationContext.getBean("action");
        System.out.println(action);
        Action action2 = (Action) applicationContext.getBean("action2");
        System.out.println(action2);

        // 装配集合属性
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);

        // 使用集合标签
        User user2 = (User) applicationContext.getBean("user2");
        System.out.println(user2);

        // 使用p命名空间
        User user3 = (User) applicationContext.getBean("user3");
        System.out.println(user3);

        //自动装配，使用bean标签的autowire属性
        Action action3 = (Action) applicationContext.getBean("action3");
        System.out.println(action3);
//        Service service3 = (Service) applicationContext.getBean("service3");
//        System.out.println(service3);
        Dao dao2 = (Dao) applicationContext.getBean("dao2");
        Dao dao3 = (Dao) applicationContext.getBean("dao2");
        System.out.println("dao2=" + dao2 + "dao3=" + dao3 + " " + (dao2 == dao3));


        // 使用parent继承
        User user4 = (User) applicationContext.getBean("user4");
        System.out.println(user4);
        User user6 = (User) applicationContext.getBean("user6");
        System.out.println(user6);
        User user5 = (User) applicationContext.getBean("user5");
        System.out.println(user5);
    }
}
