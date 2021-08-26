package com.udemy.libraryapi.service;


import com.udemy.libraryapi.domain.entity.Book;

import java.util.Optional;

public interface BookService {
    Book save(Book any);

    Optional<Book> getById(Long id);
}
