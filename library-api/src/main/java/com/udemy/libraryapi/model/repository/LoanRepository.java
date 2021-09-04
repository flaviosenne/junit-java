package com.udemy.libraryapi.model.repository;

import com.udemy.libraryapi.domain.entity.Book;
import com.udemy.libraryapi.domain.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    boolean existsByBookAndNotReturned(Book book);
}
