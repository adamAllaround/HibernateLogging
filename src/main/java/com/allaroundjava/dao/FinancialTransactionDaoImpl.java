package com.allaroundjava.dao;

import com.allaroundjava.model.FinancialTransaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Optional;
import java.util.function.Consumer;

public class FinancialTransactionDaoImpl implements FinancialTransactionDao {
    private final EntityManagerFactory emf;

    public FinancialTransactionDaoImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private void executeInTransaction(Consumer<EntityManager> consumer) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        consumer.accept(entityManager);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public Optional<FinancialTransaction> getById(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        return Optional.ofNullable(entityManager.find(FinancialTransaction.class, id));
    }

    @Override
    public void persist(FinancialTransaction item) {
        executeInTransaction(entityManager -> entityManager.persist(item));
    }
}
