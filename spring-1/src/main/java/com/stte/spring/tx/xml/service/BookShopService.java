package com.stte.spring.tx.xml.service;

public interface BookShopService {

    /**
     * 购买书籍接口
     * @param username
     * @param isbn
     */
    void purchase(String username, String isbn);
}
