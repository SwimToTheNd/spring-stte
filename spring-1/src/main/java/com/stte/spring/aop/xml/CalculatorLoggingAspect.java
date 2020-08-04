package com.stte.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * 使用XML配置切面
 */
public class CalculatorLoggingAspect {

    /**
     * 在 com.stte.spring.aop.ArithmeticCalculator 接口的每一个实现类的每一个方法开始之前执行一段代码
     */
    public void beforeMethod(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(">> The method " + methodName + "() begins with " + Arrays.asList(args));
    }

    /**
     * 在方法执行之后执行的代码. 无论该方法是否出现异常
     */
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(">> The method " + methodName + "() ends");
    }

    /**
     * 在返回通知中, 只要将 returning 属性添加到 @AfterReturning 注解中, 就可以访问连接点的返回值. 该属性的值即为用来传入返回值的参数名称.
     * 在方法法正常结束受执行的代码
     * 返回通知是可以访问到方法的返回值的!
     */
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(">> The method " + methodName + "() ends with " + result);
    }

    /**
     * 只在连接点抛出异常时才执行异常通知
     * 在目标方法出现异常时会执行的代码.
     * 可以访问到异常对象; 且可以指定在出现特定异常时在执行通知代码
     * <p>
     * 将 throwing 属性添加到 @AfterThrowing 注解中, 也可以访问连接点抛出的异常. Throwable 是所有错误和异常类的超类. 所以在异常通知方法可以捕获到任何错误和异常.
     * 如果只对某种特殊的异常类型感兴趣, 可以将参数声明为其他异常的参数类型. 然后通知就只在抛出这个类型及其子类的异常时才被执行.
     */
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + "() occurs excetion:" + e);
    }

    /**
     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数.
     * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法.
     * 且环绕通知必须有返回值, 返回值即为目标方法的返回值
     */
    public Object aroundMethod(ProceedingJoinPoint pjp) {

        Object result = null;
        String methodName = pjp.getSignature().getName();

        try {
            //前置通知
            System.out.println(methodName + " begins with " + Arrays.asList(pjp.getArgs()));
            //执行目标方法
            result = pjp.proceed();
            //返回通知
            System.out.println(methodName + " ends with " + result);
        } catch (Throwable e) {
            //异常通知
            System.out.println(methodName + " occurs exception:" + e);
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println(methodName + " ends");

        return result;
    }
}
