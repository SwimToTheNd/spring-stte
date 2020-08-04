package annoconfig;

import com.stte.spring.annoconfig.tx.MyTxConfig;
import com.stte.spring.annoconfig.tx.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring事务测试类
 * create by BloodFly at 2020/8/3
 */
public class AopTest_Tx {

    @Test
    public void testTx() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyTxConfig.class);
        BookServiceImpl bean = context.getBean(BookServiceImpl.class);
        bean.save();
    }
}
