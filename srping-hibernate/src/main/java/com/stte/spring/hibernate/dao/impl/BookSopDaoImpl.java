package com.stte.spring.hibernate.dao.impl;

import com.stte.spring.hibernate.dao.BookShopDao;
import com.stte.spring.hibernate.exception.AccountException;
import com.stte.spring.hibernate.exception.BookStockException;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * create by BloodFly at 2020/6/26
 */
@Repository
public class BookSopDaoImpl implements BookShopDao {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public double findBookPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn = ?";
        SQLQuery sqlQuery = sessionFactory.openSession().createSQLQuery(sql);
        sqlQuery.setParameter(0, isbn);

        return (Double) sqlQuery.uniqueResult();
    }

    @Override
    public int updateBookStock(String isbn) {
        // 查询书籍库存
        SQLQuery sqlQuery = sessionFactory.openSession().createSQLQuery("select stock from book_stock where isbn = ?");
        sqlQuery.setParameter(0, isbn);
        Integer stock = (Integer) sqlQuery.uniqueResult();
        System.out.println("书籍：" + isbn + " 剩余库存：" + stock);
        if (stock <= 0) {
            throw new BookStockException("书籍isbn:" + isbn + "库存不够：" + stock);
        }
        // 库存足够，减少库存
        String sql = "update book_stock set stock = stock-1 where isbn = ?";
        int result = sessionFactory.openSession()
                .createSQLQuery(sql)
                .setParameter(0, isbn)
                .executeUpdate();
        return result;
    }

    @Override
    public int updateUserAccount(String username, double price) {
        // 查询用户账户余额
        BigDecimal balance = (BigDecimal) sessionFactory.openSession()
                .createSQLQuery("select balance from account where user_name = ?")
                .setParameter(0, username).uniqueResult();
        System.out.println("账户余额：" + balance);
        if (balance.subtract(new BigDecimal(price)).doubleValue() < 0) {
            throw new AccountException("账户余额：" + balance + " 小于书籍价格：" + price);
        }
        String sql = "update account set balance = balance - ? where user_name = ?";
        int result = sessionFactory.openSession()
                .createSQLQuery(sql)
                .setParameter(0, price)
                .setParameter(1, username)
                .executeUpdate();
        return result;
    }
}
