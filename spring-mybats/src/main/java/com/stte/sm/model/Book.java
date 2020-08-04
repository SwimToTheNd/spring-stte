package com.stte.sm.model;

public class Book {
    private Integer id;

    private String isbn;

    private String bookName;

    private Double price;

    public Book(Integer id, String isbn, String bookName, Double price) {
        this.id = id;
        this.isbn = isbn;
        this.bookName = bookName;
        this.price = price;
    }

    public Book() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}