package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.CarDTO;

public interface CarService {
    public void saveCar(CarDTO carDTO) throws RuntimeException;
}
