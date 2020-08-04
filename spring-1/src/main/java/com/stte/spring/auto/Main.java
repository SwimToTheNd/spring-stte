package com.stte.spring.auto;

import com.stte.spring.ioc.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * bean的生命周期方法
 * 1. 通过构造器或工厂方法创建 Bean 实例                                             constructor
 * 2. 为 Bean 的属性设置值和对其他 Bean 的引用                                       setter
 * 3. 处理BeanNameAware接口                                                        BeanNameAware
 * 4. 处理BeanFactoryAware接口                                                     BeanFactoryAware
 * 5. 处理ApplicationContextAware接口                                              ApplicationContextAware
 * 6. 将 Bean 实例传递给 Bean 后置处理器的 postProcessBeforeInitialization 方法      postProcessBeforeInitialization
 * 7. 执行InitializingBean的afterPropertiesSet方法                                 afterPropertiesSet
 * 8. 调用 Bean 的初始化方法                                                       init
 * 9. 将 Bean 实例传递给 Bean 后置处理器的 postProcessAfterInitialization方法        postProcessAfterInitialization
 * 10. Bean 可以使用了                                                             use
 * 11. 当容器关闭时, 调用 Bean 的销毁方法                                            destroy
 * create by BloodFly at 2020/6/24
 */
public class Main {

    public static void main(String[] args) throws ParseException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-auto.xml");
        // PropertyPlaceHolderConfigurer
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);

        // Spring 表达式语言 SpEL
        User boy = (User) applicationContext.getBean("boy");
        System.out.println(boy);

        // 通过调用静态工厂方法创建bean
//        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat dateFormat = (DateFormat) applicationContext.getBean("dateFormat");
        System.out.println(dateFormat.format(new Date()));

        // 通过实例工厂方法创建bean
        Date date = (Date) applicationContext.getBean("datetime");
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parseDate = simpleDateFormat.parse("1991-12-12 12:12:12");
        System.out.println("parseDate:" + parseDate);

        // 通过FactoryBean创建实例
        User user1 = (User) applicationContext.getBean("user");
        System.out.println(user1);
        User user2 = (User) applicationContext.getBean("user");
        System.out.println(user2);
        System.out.println("(user1 == user2) = " + (user1 == user2));

        // 调用bean的销毁方法
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
