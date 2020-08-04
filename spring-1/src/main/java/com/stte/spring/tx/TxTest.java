package com.stte.spring.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 并发事务所导致的问题可以分为下面三种类型:
 * 脏读: 对于两个事物 T1, T2, T1  读取了已经被 T2 更新但 还没有被提交的字段. 之后, 若 T2 回滚, T1读取的内容就是临时且无效的.
 * 不可重复读:对于两个事物 T1, T2, T1  读取了一个字段, 然后 T2 更新了该字段. 之后, T1再次读取同一个字段, 值就不同了.
 * 幻读:对于两个事物 T1, T2, T1  从一个表中读取了一个字段, 然后 T2 在该表中插入了一些新的行. 之后, 如果 T1 再次读取同一个表, 就会多出几行.
 *
 * 事务的隔离级别要得到底层数据库引擎的支持, 而不是应用程序或者框架的支持.
 * create by BloodFly at 2020/6/26
 */
public class TxTest {

    private ApplicationContext context;
    {
        context = new ClassPathXmlApplicationContext("spring-tx.xml");
    }

    @Test
    public void testPurchase() {
        BookShopService bookShopService = (BookShopService) context.getBean("bookShopService");
        bookShopService.purchase("王小明", "AX123");
    }

}
