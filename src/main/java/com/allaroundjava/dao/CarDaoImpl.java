package com.allaroundjava.dao;

import com.allaroundjava.model.Car;
import com.allaroundjava.service.CarServiceImpl;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Optional;
import java.util.function.Consumer;

public class CarDaoImpl implements CarDao {
    private static final Logger log = Logger.getLogger(CarServiceImpl.class);
    private EntityManagerFactory emf;

    public CarDaoImpl(EntityManagerFactory emf) {
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
        log.debug(String.format("Fetching object with id %d from database", id));
        EntityManager entityManager = emf.createEntityManager();
        return Optional.ofNullable(entityManager.find(Car.class, id));
    }

    @Override
    public void persist(Car car) {
        log.debug(String.format("Persisting Car with make=%s, model=%s, manufactured=%s",
                car.getMake(), car.getModel(), car.getManufacturedAt()));
        executeInTransaction(entityManager -> entityManager.persist(car));
    }
}
