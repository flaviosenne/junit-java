package com.udemy.libraryapi.service.impl;

import com.udemy.libraryapi.domain.entity.Loan;
import com.udemy.libraryapi.model.repository.LoanRepository;
import com.udemy.libraryapi.service.LoanService;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

    private LoanRepository repository;

    public LoanServiceImpl(LoanRepository repository){
        this.repository = repository;
    }

    @Override
    public Loan save(Loan loan) {
        return repository.save(loan);
    }
}
