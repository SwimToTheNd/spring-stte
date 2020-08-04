package annoconfig;

import com.stte.spring.annoconfig.Color;
import com.stte.spring.annoconfig.Person;
import com.stte.spring.annoconfig.config.MyColorFactoryBean;
import com.stte.spring.annoconfig.config.MyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * create by BloodFly at 2020/7/29
 */
public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);

    @Test
    public void testBean() {
        //获取容器中注册的Bean的Bean定义信息
        printfBeanDefinitionNames(applicationContext);

        Person bean = (Person) applicationContext.getBean("person");
        System.out.println(bean);
    }

    @Test
    public void testImport() {
        printfBeanDefinitionNames(applicationContext);
    }

    @Test
    public void testFactoryBean() {
        printfBeanDefinitionNames(applicationContext);
        Color color = (Color) applicationContext.getBean("colorFactoryBean");
        Color color2 = (Color) applicationContext.getBean("colorFactoryBean");
        System.out.println(color == color2);
        MyColorFactoryBean myColorFactoryBean = (MyColorFactoryBean) applicationContext.getBean("&colorFactoryBean");
        System.out.println(myColorFactoryBean);
    }

    /**
     * 获取容器中注册的Bean的Bean定义信息
     * @param context
     */
    private void printfBeanDefinitionNames(AnnotationConfigApplicationContext context) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
