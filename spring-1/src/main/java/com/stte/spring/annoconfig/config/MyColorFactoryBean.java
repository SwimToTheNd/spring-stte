package com.stte.spring.annoconfig.config;

import com.stte.spring.annoconfig.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * 使用Spring的FactoryBean获取Bean
 * create by BloodFly at 2020/7/29
 */
public class MyColorFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
