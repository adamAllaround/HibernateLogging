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
        log.debug(String.format("Service request for object with id %d", id));
        return carDao.getById(id);
    }

    @Override
    public void persist(Car car) {
        log.error(String.format("Service request to persist Car with make=%s, model=%s, manufactured=%s",
                car.getMake(), car.getModel(), car.getManufacturedAt()));
        carDao.persist(car);
    }
}
