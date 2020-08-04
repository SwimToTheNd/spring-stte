package com.stte.spring.hibernate.service;

import java.util.List;

public interface CashierService {

    /**
     * 收银台批量购买书籍
     * @param username
     * @param isbns
     */
    void checkout(String username, List<String> isbns);
}
