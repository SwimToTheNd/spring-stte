package annoconfig;

import com.stte.spring.annoconfig.ext.MyApplicationEvent;
import com.stte.spring.annoconfig.ext.MyApplicationListenerConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * create by BloodFly at 2020/8/4
 */
public class IOCTest_Listener {

    @Test
    public void testApplicationListener() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyApplicationListenerConfig.class);
        //BeanFactory容器初始化后产生ContextRefreshedEvent事件
        // 发布自定义的事件
        context.publishEvent(new MyApplicationEvent("自定义的事件。。。"));
        context.close();
        //BeanFactory关闭容器后产生ContextClosedEvent事件
    }
}
