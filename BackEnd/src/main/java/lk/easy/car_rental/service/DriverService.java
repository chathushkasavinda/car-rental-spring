package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    public void saveDriver(DriverDTO driverDTO);

    public void updateDriver(DriverDTO driverDTO);

    public DriverDTO getDriver();

    public void deleteDriver(String nic);

    public List<DriverDTO> getAllDrivers();
}
