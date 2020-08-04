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
@TableName("book_stock")
public class BookStock extends Model<BookStock> {

    private static final long serialVersionUID = 1L;

    private String isbn;

    private Integer stock;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "BookStock{" +
            "isbn=" + isbn +
            ", stock=" + stock +
        "}";
    }
}
