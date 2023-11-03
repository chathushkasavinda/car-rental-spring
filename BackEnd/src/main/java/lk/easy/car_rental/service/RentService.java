package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.RentDTO;

import java.util.List;

public interface RentService {
    public void requestRent(RentDTO rentDTO);

    public String generateNewRentID();

    public List<RentDTO> getAllRents();


}
