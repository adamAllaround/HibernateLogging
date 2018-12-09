package com.allaroundjava.service;

import com.allaroundjava.dao.FinancialTransactionDao;
import com.allaroundjava.model.FinancialTransaction;

import java.util.Optional;

public class FinancialTransactionServiceImpl implements FinancialTransactionService {
    private final FinancialTransactionDao financialTransactionDao;

    public FinancialTransactionServiceImpl(FinancialTransactionDao financialTransactionDao) {
        this.financialTransactionDao = financialTransactionDao;
    }

    @Override
    public Optional<FinancialTransaction> getById(Long id) {
        return financialTransactionDao.getById(id);
    }

    @Override
    public void persist(FinancialTransaction transaction) {
        financialTransactionDao.persist(transaction);
    }
}
