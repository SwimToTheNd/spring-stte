package annoconfig;

import com.stte.spring.annoconfig.Yellow;
import com.stte.spring.annoconfig.ext.MyBeanFactoryPostProcessorConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * create by BloodFly at 2020/8/3
 */
public class IOCExtTest_BeanFactoryPostProcessor {

    @Test
    public void testBeanFactoryPostProcessor() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyBeanFactoryPostProcessorConfig.class);


        Yellow bean = context.getBean(Yellow.class);
        System.out.println(bean);
    }
}
