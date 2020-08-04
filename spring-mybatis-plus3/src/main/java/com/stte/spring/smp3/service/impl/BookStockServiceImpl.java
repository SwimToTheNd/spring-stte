package com.stte.spring.smp3.service.impl;

import com.stte.spring.smp3.entity.BookStock;
import com.stte.spring.smp3.mapper.BookStockMapper;
import com.stte.spring.smp3.service.BookStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
