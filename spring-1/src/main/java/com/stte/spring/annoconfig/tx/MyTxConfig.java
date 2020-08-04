package com.stte.spring.annoconfig.tx;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Spring 声明式事务使用注解的方式配置
 * <p>
 * 1. 相关依赖 数据源、数据库驱动、spring-jdbc
 * 2. 配置数据源Bean、Spring提供的简化的数据库操作工具：JdbcTemplate
 * 3. 配置事务管理器PlatformTransactionManager实现类DataSourceTransactionManager
 * 4. 给配置类添加注解@EnableTransactionManagement
 * 5. 给需要被事务管理器管理的方法添加@Transactional注解
 * * create by BloodFly at 2020/8/3
 */
@EnableTransactionManagement
@PropertySource(value = {"classpath:/db.properties"})
@ComponentScan
@Configuration
public class MyTxConfig {

    @Value("${jdbc.jdbcUrl}")
    private String url;
    @Value("${jdbc.user}")
    private String usernae;
    @Value("${jdbc.password}")
    private String passwd;
    @Value("${jdbc.driverClass}")
    private String driverClass;


    /**
     * 配置数据源
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClass);
        dataSource.setUsername(usernae);
        dataSource.setPassword(passwd);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }
}
