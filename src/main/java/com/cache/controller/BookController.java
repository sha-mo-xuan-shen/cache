package com.cache.controller;

import com.cache.domain.Book;
import com.cache.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.list(null);
    }

    @GetMapping("{id}")
    //返回值为存储值，参数为key
    @Cacheable(value = "cacheSpace",key = "#id")
    public Book byId(@PathVariable int id){
        return bookService.getById(id);
    }

}
