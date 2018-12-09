package com.allaroundjava.dao;

import com.allaroundjava.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Optional;
import java.util.function.Consumer;

public class CarDaoImpl implements CarDao {
    private EntityManagerFactory emf;

    CarDaoImpl(EntityManagerFactory emf) {
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
    public Optional<Car> getById(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        return Optional.ofNullable(entityManager.find(Car.class, id));
    }

    @Override
    public void persist(Car car) {
        executeInTransaction(entityManager -> entityManager.persist(car));
    }
}
