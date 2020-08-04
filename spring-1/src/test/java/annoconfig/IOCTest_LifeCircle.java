package annoconfig;

import com.stte.spring.annoconfig.Color;
import com.stte.spring.annoconfig.config.MyLifeCircleConifg;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * create by BloodFly at 2020/7/29
 */
public class IOCTest_LifeCircle {

    @Test
    public void testLifeCircle() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyLifeCircleConifg.class);
        Color color = (Color) context.getBean("color");


        //关闭容器
        context.close();
    }
}
