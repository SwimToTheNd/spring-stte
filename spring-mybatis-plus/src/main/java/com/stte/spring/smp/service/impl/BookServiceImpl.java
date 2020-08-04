package com.stte.spring.smp.service.impl;

import com.stte.spring.smp.entity.Book;
import com.stte.spring.smp.mapper.BookMapper;
import com.stte.spring.smp.service.BookService;
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
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
