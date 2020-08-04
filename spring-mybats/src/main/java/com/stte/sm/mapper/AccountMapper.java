package com.stte.sm.mapper;

import com.stte.sm.model.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    Account findAccountById(int id);

    int save(@Param("account") Account account);
}
