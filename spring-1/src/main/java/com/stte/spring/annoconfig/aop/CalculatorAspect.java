package com.stte.spring.annoconfig.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * create by BloodFly at 2020/8/2
 */
@Aspect
//@Component
public class CalculatorAspect {

    // 定义切点
    @Pointcut("execution(public double com.stte.spring.annoconfig.aop.Calculator.*(..))")
    public void pointCut() {

    }

    //程序执行前执行的通知
    @Before("pointCut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("方法" + joinPoint.getSignature().getName() + " @Before开始执行 " + Arrays.toString(joinPoint.getArgs()));
    }

    //程序执行完后执行的通知
    @After("pointCut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("方法 " + joinPoint.getSignature().getName() + " @After执行完毕");
    }

    //程序返回后执行的通知
    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("方法 " + joinPoint.getSignature().getName() + " @AfterReturning执行结束，返回值为：" + result);
    }

    //程序抛出异常后执行的通知
    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("方法 " + joinPoint.getSignature().getName() + " @AfterThrowing执行异常：" + e);
    }
}
