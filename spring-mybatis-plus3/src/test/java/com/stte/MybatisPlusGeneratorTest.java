package com.stte;

import com.stte.spring.smp3.entity.Book;
import com.stte.spring.smp3.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * create by BloodFly at 2020/7/2
 */
public class MybatisPlusGeneratorTest {

    private ApplicationContext applicationContext;
    private BookService bookService;
    {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        bookService = applicationContext.getBean(BookService.class);
    }


    @Test
    public void testFind() {
        List<Book> list = bookService.list();
        System.out.println(list);
    }
}
