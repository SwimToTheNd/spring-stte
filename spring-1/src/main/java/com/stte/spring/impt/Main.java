package com.stte.spring.impt;

import com.stte.spring.annotation.CarService;
import com.stte.spring.annotation.UserAction;
import com.stte.spring.annotation.UserService2;
import com.stte.spring.ioc.Car;
import com.stte.spring.ioc.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用<import>整合多个配置文件
 */
public class Main {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-import.xml");
        UserAction userAction = (UserAction) applicationContext.getBean("userAction");
        userAction.execute();

        // spring 4新增 泛型依赖注入
        UserService2 userService2  = (UserService2) applicationContext.getBean("userService2");
        User user = new User();
        user.setName("刘仙");
        user.setWifeName("梁泳");
        userService2.save(user);

        CarService carService = (CarService) applicationContext.getBean("carService");
        carService.save(new Car("桑塔拉", "广东汽车厂", 9988.22, 56));
    }
	
}
