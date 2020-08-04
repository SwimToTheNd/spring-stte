package com.stte.spring.annoconfig.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 使用注解@EnableAspectJAutoProxy开启为切面自动创建代理
 *
 * 1.将业务逻辑组件和切面类加入容器，告诉Spring哪些组件是切面，使用@Aspect。
 * 2.在切面上定义切点和通知。使用切面表达式
 * 3.开启基于注解的AOP模式，使用@EnableAspectJAutoProxy
 *
 * create by BloodFly at 2020/8/2
 */
@Configuration
@EnableAspectJAutoProxy
//@ComponentScan(basePackages = "com.stte.spring.annoconfig.aop")
public class MyAopConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    /**
     * 在CalculatorAspect类上加上注解@Aspect，告诉该类为一个切面。
     * @return
     */
    @Bean
    public CalculatorAspect calculatorAspect() {
        return new CalculatorAspect();
    }
}
