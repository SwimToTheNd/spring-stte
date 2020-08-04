package com.stte.spring.smp3.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stte
 * @since 2020-07-02
 */
@TableName("book")
public class Book extends Model<Book> {

    private static final long serialVersionUID = 1L;

    private String isbn;

    private String bookName;

    private Double price;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "Book{" +
            "isbn=" + isbn +
            ", bookName=" + bookName +
            ", price=" + price +
        "}";
    }
}
