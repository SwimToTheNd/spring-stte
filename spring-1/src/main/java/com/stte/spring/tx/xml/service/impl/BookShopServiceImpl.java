package com.stte.spring.tx.xml.service.impl;

import com.stte.spring.tx.xml.dao.BookShopDao;
import com.stte.spring.tx.xml.service.BookShopService;

/**
 * create by BloodFly at 2020/6/26
 */
public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    /**
     * @param username
     * @param isbn
     * @Transactional 注解来标注事务方法
     * <p>
     * 根据 Spring AOP 基于代理机制, 只能标注公有方法.可以在方法或者类级别上添加 @Transactional 注解.
     * 当把这个注解应用到类上时, 这个类中的所有公共方法都会被定义成支持事务处理的.
     */
    @Override
    public void purchase(String username, String isbn) {
        // 查询书价
        double bookPrice = bookShopDao.findBookPriceByIsbn(isbn);
        System.out.println("书：" + isbn + " 价格：" + bookPrice);
        // 修改库存
        int result = bookShopDao.updateBookStock(isbn);
        System.out.println("减少库存update结果：" + result);
        // 减少余额
        result = bookShopDao.updateUserAccount(username, bookPrice);
        System.out.println("减少余额update结果：" + result);
    }
}
