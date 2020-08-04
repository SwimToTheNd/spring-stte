package com.stte.sm.model;

public class BookStock {
    private Integer id;

    private String isbn;

    private Integer stock;

    public BookStock(Integer id, String isbn, Integer stock) {
        this.id = id;
        this.isbn = isbn;
        this.stock = stock;
    }

    public BookStock() {
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}