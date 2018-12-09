package com.allaroundjava.dao;

import com.allaroundjava.model.FinancialTransaction;

import java.util.Optional;

public interface FinancialTransactionDao {
    Optional<FinancialTransaction> getById(Long id);

    void persist(FinancialTransaction transaction);
}
