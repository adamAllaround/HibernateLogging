package com.allaroundjava.service;

import com.allaroundjava.model.FinancialTransaction;

import java.util.Optional;

public interface FinancialTransactionService {
    Optional<FinancialTransaction> getById(Long id);

    void persist(FinancialTransaction transaction);
}
