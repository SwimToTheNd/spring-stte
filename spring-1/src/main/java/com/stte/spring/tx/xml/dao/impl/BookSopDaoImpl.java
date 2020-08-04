package com.stte.spring.tx.xml.dao.impl;

import com.stte.spring.tx.xml.exception.AccountException;
import com.stte.spring.tx.xml.exception.BookStockException;
import com.stte.spring.tx.xml.dao.BookShopDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

/**
 * create by BloodFly at 2020/6/26
 */
public class BookSopDaoImpl implements BookShopDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public double findBookPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn = ?";
        Double price = jdbcTemplate.queryForObject(sql, Double.class, isbn);
        return price;
    }

    @Override
    public int updateBookStock(String isbn) {
        // 查询书籍库存
        Integer stock = jdbcTemplate.queryForObject("select stock from book_stock where isbn = ?", Integer.class, isbn);
        System.out.println("书籍：" + isbn + " 剩余库存：" + stock);
        if (stock <= 0) {
            throw new BookStockException("书籍isbn:" + isbn + "库存不够：" + stock);
        }
        // 库存足够，减少库存
        String sql = "update book_stock set stock = stock-1 where isbn = ?";
        int result = jdbcTemplate.update(sql, isbn);
        return result;
    }

    @Override
    public int updateUserAccount(String username, double price) {
        // 查询用户账户余额
        BigDecimal balance = jdbcTemplate.queryForObject("select balance from account where user_name = ?", BigDecimal.class, username);
        System.out.println("账户余额：" + balance);
        if (balance.subtract(new BigDecimal(price)).doubleValue() < 0) {
            throw new AccountException("账户余额：" + balance + " 小于书籍价格：" + price);
        }
        String sql = "update account set balance = balance - ? where user_name = ?";
        int result = jdbcTemplate.update(sql, price, username);
        return result;
    }
}
