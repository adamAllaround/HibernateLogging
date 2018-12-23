package com.allaroundjava.service;

import com.allaroundjava.dao.CarDaoImpl;
import com.allaroundjava.dao.Dao;
import com.allaroundjava.model.Car;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class CarServiceImplTest {

    private static EntityManagerFactory emf;
    private static Dao<Car> carDao;
    private static CarService carService;
    @BeforeClass
    public static void setUp() {
        emf = Persistence.createEntityManagerFactory("hibernateLogging");
        carDao = new CarDaoImpl(emf);
        carService = new CarServiceImpl(carDao);
    }

    @Test
    public void whenPersist_thenNoException() {
        Car car = Car.newInstance(
                "BMW",
                "M3",
                LocalDate.of(2018, 12, 8));

        carService.persist(car);
    }
}