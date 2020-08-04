package com.stte.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 使用动态代理作为代理输出日志
 *
 * 代理设计模式的原理: 使用一个代理将原始对象包装起来, 然后用该代理对象取代原始对象.
 * 任何对原始对象的调用都要通过代理. 代理对象决定是否以及何时将方法调用转到原始对象上.
 * create by BloodFly at 2020/6/25
 */
public class CalculatorLoggingHandler implements InvocationHandler {

    private Object target;

    public CalculatorLoggingHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("the method " + method.getName() + "() begin with args: " + Arrays.toString(args));
        Object result = method.invoke(target, args);
        System.out.println("the method " + method.getName() + "() end with result: " + result);
        return result;
    }

    public static Object  createProxy(Object target) {
        // classloader, interfaces, invocation handler
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new CalculatorLoggingHandler(target));
        return proxy;
    }
}
