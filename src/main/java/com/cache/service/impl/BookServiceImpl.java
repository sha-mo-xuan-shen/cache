package com.cache.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cache.dao.BookDao;
import com.cache.domain.Book;
import com.cache.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book>  implements BookService{

    @Autowired
    BookDao bookDao;

    //手动存取缓存
    public HashMap<Integer,Book> cache = new HashMap<>();
    // @Override
    // public Book getById(int id) {
    //     if(null==cache.get(id)){
    //         cache.put(id,bookDao.selectById(id));
    //     }
    //     return cache.get(id);
    // }
    @Override
    public Book getById(int id) {
        return bookDao.selectById(id);
    }
}
