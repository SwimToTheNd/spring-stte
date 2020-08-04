package com.stte.spring.smp3.service.impl;

import com.stte.spring.smp3.entity.Book;
import com.stte.spring.smp3.mapper.BookMapper;
import com.stte.spring.smp3.service.BookService;
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
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
