package com.udemy.libraryapi.service;

import com.udemy.libraryapi.api.resource.BookController;
import com.udemy.libraryapi.domain.entity.Book;
import com.udemy.libraryapi.domain.entity.Loan;

import java.util.Optional;

public interface LoanService {
    Loan save(Loan loan);

    Optional<Loan> getById(Long id);

    Loan update(Loan loan);
}
