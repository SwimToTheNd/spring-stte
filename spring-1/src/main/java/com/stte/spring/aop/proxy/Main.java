package com.stte.spring.aop.proxy;

import com.stte.spring.aop.ArithmeticCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by BloodFly at 2020/6/25
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) context.getBean("arithmeticCalculator");
        arithmeticCalculator.add(1, 2);
        arithmeticCalculator.mul(2, 4);
        // 使用动态代理，先创建检验代理，再在此基础上创建输出日志的代理
        ArithmeticCalculator calculator = (ArithmeticCalculator) CalculatorLoggingHandler
                .createProxy(CalculatorValidateHandler.createProxy(arithmeticCalculator));
        calculator.add(1, 2);
        calculator.mul(2, 4);
        calculator.div(2, 4);
        //
        calculator.add(1, -1);
    }
}
