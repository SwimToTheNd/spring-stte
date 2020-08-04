package com.stte.spring.annoconfig.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.stte.spring.annoconfig.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/**
 * Profile: 根据当前所属环境，动态的切换和激活一系列组件的功能，结合@Profile注解使用
 * <p>
 * 一般有开发环境、测试环境、生产环境
 * <p>
 * 使用@Profile标注Bean，只有与当前激活的环境一致时，对应的Bean才会生效。默认是default。
 *
 * 有两种方法可以切换环境，切换环境后，标注@Profile指定环境的Bean只有在对应的环境时都会被激活。对于没有指定环境标识的Bean仍然生效
 * 1. 通过对jvm添加启动参数的方式：Spring.profiles.active=dev,test，可以指定多个用逗号隔开
 * 2. 通过编码的方法设置环境。
 *      1. 使用ApplicationContext的无参构造函数
 *      2. 指定要加载的配置类或资源
 *      3. 调用ApplicationContext获得Environment环境对象，并设置当前激活的环境，可以设置多个
 *      4. 调用refresh()启动刷新容器
 *
 * 注解@Profile如果标注在类上，则该下所有标注了@Profile配置的注解，只有和类上标注的@Profile指定的环境一致时对应的Bean才会生效，
 * 没有标注@Profile的Bean不会生效。
 * create by BloodFly at 2020/8/2
 */
@Profile("test")
@PropertySource("classpath:/db.properties")
@Configuration
public class MyProfileConfig implements EmbeddedValueResolverAware {

    // 使用@Value注解注入环境变量的属性值
    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.driverClass}")
    private String driverClass;

    //使用EmbeddedValueResolver解析环境属性值
    private String jdbcUrl;

    /**
     * 开发环境DataSource
     *
     * @param password
     * @return
     * @throws PropertyVetoException
     */
    @Profile("dev")
    @Bean("devDatasource")
    public DataSource dataSourceDev(@Value("${jdbc.password)") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * 测试环境DataSource
     *
     * @param password
     * @return
     * @throws PropertyVetoException
     */
    @Profile("test")
    @Bean("testDatasource")
    public DataSource dataSourceTest(@Value("${jdbc.password)") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * 生产环境DataSource
     *
     * @param password
     * @return
     * @throws PropertyVetoException
     */
    @Profile("prod")
    @Bean("prodDatasource")
    public DataSource dataSourceProd(@Value("${jdbc.password)") String password) throws PropertyVetoException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    // 指定了其他环境时，该Bean就不会生效了
//    @Profile("default")
    @Bean
    public Yellow yellow() {
        return new Yellow();
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        jdbcUrl = stringValueResolver.resolveStringValue("${jdbc.jdbcUrl}");
    }
}
