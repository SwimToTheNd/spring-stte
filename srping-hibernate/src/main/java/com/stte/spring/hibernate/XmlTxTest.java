package com.stte.spring.hibernate;

import com.stte.spring.hibernate.service.BookShopService;
import com.stte.spring.hibernate.service.CashierService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * create by BloodFly at 2020/6/26
 */
public class XmlTxTest {
    private ApplicationContext context;
    private BookShopService bookShopService;
    private CashierService cashierService;

    {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        bookShopService = (BookShopService) context.getBean("bookShopService");
        cashierService = (CashierService) context.getBean("cashierService");
    }

    @Test
    public void testPurchase() {
        bookShopService.purchase("王小明", "AX123");
    }

    @Test
    public void testCashier() {
        cashierService.checkout("王小明", Arrays.asList("AX123", "AX124"));
    }
}
