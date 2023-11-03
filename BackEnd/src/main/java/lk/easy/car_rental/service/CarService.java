package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.CarDTO;

import java.util.List;

public interface CarService {
    public void saveCar(CarDTO carDTO) throws RuntimeException;

    public List<CarDTO> getAllCars() throws RuntimeException;
}
