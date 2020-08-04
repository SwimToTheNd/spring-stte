package com.stte.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static java.lang.reflect.Proxy.newProxyInstance;

/**
 * create by BloodFly at 2020/6/25
 */
public class CalculatorValidateHandler implements InvocationHandler {

    private Object target;

    public CalculatorValidateHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args == null || args.length < 2) {
            throw new RuntimeException("计算器需要转入2个参数！");
        }

        for (Object arg : args) {
            if (arg == null || (Integer) arg < 0) {
                throw new RuntimeException("计算器只能处理正数！");
            }
        }
        Object result = method.invoke(target, args);
        return result;
    }

    public static Object createProxy(Object target) {
        Object proxy = newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new CalculatorValidateHandler(target));
        return proxy;
    }
}
