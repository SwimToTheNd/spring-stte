package com.stte.spring.annoconfig.tx.service;

import com.stte.spring.annoconfig.tx.dao.BookDao;
import com.stte.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.UUID;

/**
 * create by BloodFly at 2020/8/3
 */
@Service
public class BookServiceImpl {

    @Autowired
    private BookDao bookDao;

    @Transactional
    public void save() {
        Random random = new Random();
        Book book = new Book();
        book.setIsbn(UUID.randomUUID().toString().substring(0, 6));
        book.setBookName("深入JVM虚拟机" + random.nextInt(10));
        book.setPrice((double) Math.round(random.nextDouble() * 10000) / 100);
        bookDao.save(book);
        int i = 1 / 0;
    }
}
