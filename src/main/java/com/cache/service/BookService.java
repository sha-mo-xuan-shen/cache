package com.cache.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cache.domain.Book;

public interface BookService extends IService<Book> {

    public Book getById(int id);
}
