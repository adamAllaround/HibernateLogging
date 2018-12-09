package com.allaroundjava.service;

import com.allaroundjava.dao.CarDao;
import com.allaroundjava.model.Car;
import org.jboss.logging.Logger;

import java.util.Optional;

public class CarServiceImpl implements CarService {
    private static final Logger log = Logger.getLogger(CarServiceImpl.class);
    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public Optional<Car> getById(Long id) {
        return carDao.getById(id);
    }

    @Override
    public void persist(Car transaction) {
        carDao.persist(transaction);
    }
}
