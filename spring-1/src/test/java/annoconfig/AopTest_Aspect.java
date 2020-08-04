package annoconfig;

import com.stte.spring.annoconfig.aop.Calculator;
import com.stte.spring.annoconfig.aop.MyAopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * create by BloodFly at 2020/8/2
 */
public class AopTest_Aspect {

    @Test
    public void testAsepect() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAopConfig.class);
        Calculator bean = context.getBean(Calculator.class);
        System.out.println(bean.divide(2, 5));
        System.out.println(bean.divide(2, 0));
    }
}
