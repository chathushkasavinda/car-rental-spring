package lk.easy.car_rental.service.impl;

import lk.easy.car_rental.dto.CustomerDTO;
import lk.easy.car_rental.entity.Customer;
import lk.easy.car_rental.repo.CustomerRepo;
import lk.easy.car_rental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
//    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCustomer(@RequestBody CustomerDTO customerDTO) throws RuntimeException {
        customerDTO.getUser().setRole("Customer");
        customerRepo.save(mapper.map(customerDTO, Customer.class));
    }

    @Override
    public List<CustomerDTO> getAllCustomer() throws RuntimeException {
        return null;
    }
}
