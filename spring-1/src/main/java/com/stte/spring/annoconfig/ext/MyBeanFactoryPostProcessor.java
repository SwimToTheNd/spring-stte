package com.stte.spring.annoconfig.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * BeanFactory后置处理器。
 * BeanFactory容器创建后，调用BeanFactoryPostProcessor的postProcessBeanFactory方法
 * <p>
 * create by BloodFly at 2020/8/3
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        System.out.println("constructor...");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        int beanDefinitionCount = configurableListableBeanFactory.getBeanDefinitionCount();
        System.out.println("容器中含有BeanDefinition的个数：" + beanDefinitionCount);
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        System.out.println("Bean定义信息有：" + Arrays.toString(beanDefinitionNames));
    }
}
