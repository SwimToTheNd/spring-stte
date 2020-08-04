package com.stte.spring.hibernate.service.impl;

import com.stte.spring.hibernate.service.BookShopService;
import com.stte.spring.hibernate.service.CashierService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by BloodFly at 2020/6/26
 */
@Service("cashierService")
public class CashierServiceImpl implements CashierService {

    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(String username, List<String> isbns) {
        for(String isbn: isbns){
            bookShopService.purchase(username, isbn);
        }
    }
}
