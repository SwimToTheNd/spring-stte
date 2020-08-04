package com.stte.sm.service;

import com.stte.sm.model.Account;

/**
 * create by BloodFly at 2020/7/1
 */
public interface AccountService {

    Account findAccountById(int id);

    int save(Account account);
}
