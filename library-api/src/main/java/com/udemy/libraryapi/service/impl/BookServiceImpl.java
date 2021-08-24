package com.udemy.libraryapi.service.impl;

import com.udemy.libraryapi.domain.entity.Book;
import com.udemy.libraryapi.model.repository.BookRepository;
import com.udemy.libraryapi.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository){
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }
}
