package com.stte.sm;

import com.stte.sm.model.Account;
import com.stte.sm.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * create by BloodFly at 2020/7/1
 */
public class AccountTest {
    
    private ApplicationContext applicationContext;
    private AccountService accountService;
    {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        accountService = (AccountService) applicationContext.getBean("accountService");
    }
    
    
    @Test
    public void testFindById() {
        System.out.println(accountService.findAccountById(13));
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setUserName("韩立");
        account.setBalance(new BigDecimal("2998320.88"));
        System.out.println(accountService.save(account));
    }
}
