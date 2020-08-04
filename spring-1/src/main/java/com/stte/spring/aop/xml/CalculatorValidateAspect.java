package com.stte.spring.aop.xml;

import org.aspectj.lang.JoinPoint;

/**
 * 计算器较验切面
 * 切面的优先级可以通过实现 Ordered 接口或利用 @Order 注解指定.
 * 实现 Ordered 接口, getOrder() 方法的返回值越小, 优先级越高.切面逻辑越先执行
 * 若使用 @Order 注解, 序号出现在注解中
 * create by BloodFly at 2020/6/25
 */
public class CalculatorValidateAspect {

    public void validateBefore(JoinPoint joinPoint) {
        System.out.println("calculator validate method:" + joinPoint.getSignature().getName() + " begin......");
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length < 2) {
            throw new RuntimeException("计算器需要2个参数！");
        }
        for (Object arg : args) {
            if (arg == null || (Integer) arg < 0) {
                throw new RuntimeException("计算器参数为负数！");
            }
        }
    }
}
