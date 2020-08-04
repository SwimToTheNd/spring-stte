package com.stte.spring.annoconfig.tx.dao;

import com.stte.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * create by BloodFly at 2020/8/3
 */
@Repository
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Book book) {
        String sql = "insert into book (isbn,book_name,price) value (?,?,?)";
        int update = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, book.getIsbn());
                preparedStatement.setString(2, book.getBookName());
                preparedStatement.setDouble(3, book.getPrice());
            }
        });
        System.out.println("插入 " + update + " 本书籍：" + book);
        return update;
    }
}
