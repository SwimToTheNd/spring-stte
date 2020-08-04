package com.stte.spring.annoconfig.config;

import com.stte.spring.annoconfig.Color;
import org.springframework.context.annotation.*;

/**
 * Spring Bean的生命周期
 * create by BloodFly at 2020/7/29
 */
@Configuration
@ComponentScan(basePackages = "com.stte.spring.annoconfig.config",
        excludeFilters = {
                @ComponentScan.Filter(value = {Import.class})
        })
public class MyLifeCircleConifg {

    /**
     * 设置Bean的init-method和destory-method
     * 执行顺序：
     * 类的构造器
     * 显示调用的setter
     * BeanPostProcessor的postProcessBeforeInitialization方法
     * JSR250的@PostConstruct标注的方法
     * InitializingBean的afterPropertiesSet方法
     * init-method
     * BeanPostProcessor的postProcessAfterInitialization方法
     * <p>
     * JSR250的@PreDestory标注的方法
     * destory-method
     * <p>
     * AbstractAutowireCapableBeanFactory#populateBean 实例化Bean
     * AbstractAutowireCapableBeanFactory#initializeBean 初始化bean
     * AbstractAutowireCapableBeanFactory#invokeAwareMethods 执行Aware接口
     * AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization 执行自定义的BeanPostProcessor的BeforeInitialization方法
     * AbstractAutowireCapableBeanFactory#invokeInitMethods 调用Beanr init-method
     * AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsAfterInitialization 执行自定义的BeanPostProcessor的AfterInitialization方法
     *
     * @return
     * @Autowire、@PostConstruct、@PreDestory、ApplicationsContextAware等都是通过BeanPostProcessor来实现的。
     */
    @Bean(initMethod = "init", destroyMethod = "destory")
    @Primary
    public Color color() {
        Color color = new Color();
        color.setName("颜色");
        return color;
    }
}
