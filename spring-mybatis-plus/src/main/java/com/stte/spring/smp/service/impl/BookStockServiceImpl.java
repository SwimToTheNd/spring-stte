package com.stte.spring.smp.service.impl;

import com.stte.spring.smp.entity.BookStock;
import com.stte.spring.smp.mapper.BookStockMapper;
import com.stte.spring.smp.service.BookStockService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stte
 * @since 2020-07-02
 */
@Service
public class BookStockServiceImpl extends ServiceImpl<BookStockMapper, BookStock> implements BookStockService {

}
