package com.stte.spring.annoconfig.config;

import com.stte.spring.annoconfig.Color;
import com.stte.spring.annoconfig.Person;
import com.stte.spring.annoconfig.Red;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * 通过@Import 注解将一般的类注册的Spring容器中（没有使用@Controller、@Component、@Service、@Repository、@Bean等）
 * 注解@Import：
 * 1）导入一般的类到容器
 * 2）导入ImportSelector接口返回的组件、ImportSelector返回需要注入到容器类的全类名数组
 * 3）导入ImportBeanDefinitionRegister接口返回的BeanDefinition，手动注册BeanDefinition
 * create by BloodFly at 2020/7/29
 */
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegister.class})
public class MyConfig {

    /**
     * 使用@Bean注解  调用方法将Bean注册到Spring容器中。
     * <p>
     * 使用@Scope注解 指明Bean的作用范围有，主要有
     * 原型：ConfigurableBeanFactory.SCOPE_PROTOTYPE，
     * 单例：ConfigurableBeanFactory.SCOPE_SINGLETON
     * web环境中REQUEST: WebApplicationContext.SCOPE_REQUEST
     * web环境中SESSION: WebApplicationContext.
     * <p>
     * 使用@Lazy注解 如果作用范围是单例，是否要延迟加载
     *
     * @return
     */
    @Bean("person")
    @Lazy(false)
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Person getPerson01() {
        System.out.println("构造Person对象....");
        return new Person();
    }

    /**
     * 根据@Conditional注解配置是否要将Bean注册到IOC容器中
     * 注解@Conditional需要实现了Condition接口的数组作为参数，返回值为true时才创建Bean
     *
     * @return
     */
    @Conditional({WindowCondition.class})
    @Bean("Bill Gates")
    public Person getPerson02() {
        return new Person("Bill Gates", 66);
    }

    @Conditional({LinuxCondition.class})
    @Bean("Linus")
    public Person getPerson03() {
        return new Person("Linus", 48);
    }


    /**
     * 使用Spring提供的FactoryBean获取Color bean
     * 虽然方法名叫colorFactoryBean，但这是Color bean的id
     * 使用&colorFactoryBean获取FactoryBean本身，否则使用colorFactoryBean获取的是Color对象
     *
     * @return
     */
    @Bean
    public MyColorFactoryBean colorFactoryBean() {
        return new MyColorFactoryBean();
    }
}
