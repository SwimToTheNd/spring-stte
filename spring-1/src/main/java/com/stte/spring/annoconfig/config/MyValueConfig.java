package com.stte.spring.annoconfig.config;

import com.stte.spring.annoconfig.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * create by BloodFly at 2020/7/29
 * 注解@PropertySource读取外部的配置文件中的K/V到运行环境变量中，使用@Value("${}")可以读取配置
 */
@Configuration
@PropertySource(value = {"classpath:config.properties"}, encoding = "utf-8")
public class MyValueConfig {


    /**
     * 使用@Value给Bean属性赋值
     *
     * @return
     */
    @Bean
    public Person person() {
        return new Person();
    }
}
