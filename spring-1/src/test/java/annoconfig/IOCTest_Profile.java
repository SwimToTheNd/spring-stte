package annoconfig;

import com.stte.spring.annoconfig.Yellow;
import com.stte.spring.annoconfig.config.MyProfileConfig;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * create by BloodFly at 2020/8/2
 */
public class IOCTest_Profile {


    @Test
    public void testProfile() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyProfileConfig.class);
        String[] dataSourceBeanNames = applicationContext.getBeanNamesForType(DataSource.class);
        System.out.println(Arrays.toString(dataSourceBeanNames));
        for (String dataSourceBeanName : dataSourceBeanNames) {
            BeanDefinition beanDefinition = ((AnnotationConfigApplicationContext) applicationContext).getBeanDefinition(dataSourceBeanName);
            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
            System.out.println(propertyValues.getPropertyValueList());
            System.out.println(beanDefinition);
            System.out.println(applicationContext.getBean(dataSourceBeanName));
        }

    }

    /**
     * 通过JVM启动参数-Dspring.profiles.active=dev设置环境
     */
    @Test
    public void testActiveProfileByJvm() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyProfileConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanNamesForType(DataSource.class);
        System.out.println(Arrays.toString(beanDefinitionNames));
        System.out.println(applicationContext.getBean(Yellow.class));
    }

    /**
     * 通过编码的方式切换环境
     */
    @Test
    public void testActiveProfileByCode() {
        // 调用ApplicationContext的无参数构造器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类或配置资源
        applicationContext.register(MyProfileConfig.class);
        // 设置激活的环境
        applicationContext.getEnvironment().setActiveProfiles("dev", "prod");
        // 刷新容器
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        System.out.println(Arrays.toString(beanNamesForType));
        System.out.println(applicationContext.getBean(Yellow.class));
    }
}
