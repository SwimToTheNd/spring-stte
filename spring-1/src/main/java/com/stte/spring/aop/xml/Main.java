package com.stte.spring.aop.xml;

import com.stte.spring.aop.ArithmeticCalculator;
import com.stte.spring.aop.MaxCalculator;
import com.stte.spring.aop.MinCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by BloodFly at 2020/6/25
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aspect-xml.xml");
        ArithmeticCalculator calculator = (ArithmeticCalculator) context.getBean("arithmeticCalculator");
        calculator.add(1, 2);
        calculator.mul(2, 2);

        // 引入通知
        MaxCalculator maxCalculator = (MaxCalculator) context.getBean("arithmeticCalculator");
        System.out.println("max value is: " + maxCalculator.max(1, 2));
        MinCalculator minCalculator = (MinCalculator) context.getBean("arithmeticCalculator");
        System.out.println("min value is: " + minCalculator.min(1, 2));

        calculator.div(2, -1);
//        calculator.div(4, 0);
    }
}
