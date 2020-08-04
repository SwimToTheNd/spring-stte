package com.stte.spring.annoconfig.ext;

import com.stte.spring.annoconfig.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * BeanFactoryPostProcessor的配置类
 * <p>
 * BeanFactoryPostProcessor在BeanFactory容器创建后之后执行。此时Bean还没有实例化
 * create by BloodFly at 2020/8/3
 */
@ComponentScan
@Configuration
public class MyBeanFactoryPostProcessorConfig {

    @Bean
    public Color color() {
        return new Color();
    }
}
