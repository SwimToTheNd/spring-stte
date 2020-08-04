package com.stte.sm.service.impl;

import com.stte.sm.mapper.AccountMapper;
import com.stte.sm.model.Account;
import com.stte.sm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * create by BloodFly at 2020/7/1
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findAccountById(int id) {
        return accountMapper.findAccountById(id);
    }

    @Transactional
    @Override
    public int save(Account account) {
        int result = accountMapper.save(account);
        int i = 1 / 0;
        return result;
    }
}
