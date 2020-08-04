package com.stte.spring.hibernate.exception;

/**
 * 图书库存异常类
 * create by BloodFly at 2020/6/26
 */
public class BookStockException extends RuntimeException {

    public BookStockException() {
        super();
    }

    public BookStockException(String message) {
        super(message);
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockException(Throwable cause) {
        super(cause);
    }

    protected BookStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
