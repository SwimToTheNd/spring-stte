package com.stte.spring.hibernate.service;

public interface BookShopService {

    /**
     * 购买书籍接口
     * @param username
     * @param isbn
     */
    void purchase(String username, String isbn);
}
