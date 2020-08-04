package com.stte.spring.auto;

import com.stte.spring.ioc.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean的后置处理器，需要配置该后置处理器到容器
 * bean的生命周期
 * 1. 通过构造器或工厂方法创建 Bean 实例
 * 2. 为 Bean 的属性设置值和对其他 Bean 的引用
 * 3. 将 Bean 实例传递给 Bean 后置处理器的 postProcessBeforeInitialization 方法
 * 4. 调用 Bean 的初始化方法
 * 5. 将 Bean 实例传递给 Bean 后置处理器的 postProcessAfterInitialization方法
 * 6. Bean 可以使用了
 * 7. 当容器关闭时, 调用 Bean 的销毁方法
 * create by BloodFly at 2020/6/24
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 该方法在 init 方法之前被调用
     * 可以工作返回的对象来决定最终返回给 getBean 方法的对象是哪一个, 属性值是什么
     * @param o bean对象
     * @param s bean的名称
     * @return
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if ("boy".equals(s)) {
            System.out.println("postProcessBeforeInitialization..." + o + "," + s);
        }
        return o;
    }

    /**
     * 该方法在 init 方法之后被调用
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        // 在bean初始化之后，修改bean的属性
        if ("boy".equals(s)) {
            System.out.println("postProcessAfterInitialization..." + o + "," + s);
            User user = (User) o;
            user.setName("李大齐");
        }
        return o;
    }
}
