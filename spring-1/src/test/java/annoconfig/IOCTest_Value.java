package annoconfig;

import com.stte.spring.annoconfig.Person;
import com.stte.spring.annoconfig.config.MyValueConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * create by BloodFly at 2020/7/29
 */
public class IOCTest_Value {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyValueConfig.class);

    @Test
    public void testValue() {
        Person person = (Person) context.getBean("person");
        System.out.println(person);

        //可以使用Environment运行时环境变量来获取配置
        ConfigurableEnvironment environment = context.getEnvironment();
        String nickName = environment.getProperty("person.nickName");
        System.out.println(nickName);

    }
}
