package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.CustomerDTO;
import lk.easy.car_rental.dto.CustomerImageDTO;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(CustomerDTO customerDTO) throws RuntimeException;
    public List<CustomerDTO> getAllCustomer() throws RuntimeException;
    public void updateCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(String nic);
    public void saveImages(String nic, CustomerImageDTO imageDTO) throws RuntimeException;


}
