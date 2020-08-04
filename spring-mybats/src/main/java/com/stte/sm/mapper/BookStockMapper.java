package com.stte.sm.mapper;

import com.stte.sm.model.BookStock;

public interface BookStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookStock record);

    int insertSelective(BookStock record);

    BookStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookStock record);

    int updateByPrimaryKey(BookStock record);
}