package com.stte.spring.aop.aspect;

import com.stte.spring.aop.MaxCalculator;
import com.stte.spring.aop.MaxCalculatorImpl;
import com.stte.spring.aop.MinCalculator;
import com.stte.spring.aop.MinCalculatorImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * 引入通知
 * <p>
 * 让类实现多个其他接口，而不用修改代码
 * <p>
 * 引入通知可以使用两个实现类 MaxCalculatorImpl 和 MinCalculatorImpl, 让 ArithmeticCalculatorImpl 动态地实现 MaxCalculator 和 MinCalculator 接口.
 * 而这与从 MaxCalculatorImpl 和 MinCalculatorImpl 中实现多继承的效果相同. 但却不需要修改 ArithmeticCalculatorImpl 的源代码
 * <p>
 * 引入通知也必须在切面中声明
 * <p>
 * 在切面中, 通过为任意字段添加@DeclareParents 注解来引入声明.
 * <p>
 * 注解类型的 value 属性表示哪些类是当前引入通知的目标. value 属性值也可以是一个 AspectJ 类型的表达式, 以将一个即可引入到多个类中.
 * defaultImpl 属性中指定这个接口使用的实现类
 * <p>
 * 让匹配Arithmetic*的类实现MaxCalculator，MinCalculator接口，接口的实现类为MaxCalculatorImpl.class和MinCalculatorImpl.class
 * create by BloodFly at 2020/6/25
 */

@Aspect
@Component
public class InterdouceAspect {

    @DeclareParents(value = "*com.stte.spring.aop.Arithmetic*", defaultImpl = MaxCalculatorImpl.class)
    private MaxCalculator maxCalculator;

    @DeclareParents(value = "com.stte.spring.aop.Arithmetic*", defaultImpl = MinCalculatorImpl.class)
    private MinCalculator minCalculator;


}
