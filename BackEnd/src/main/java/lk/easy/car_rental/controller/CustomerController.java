package lk.easy.car_rental.controller;

import lk.easy.car_rental.service.CustomerService;
import lk.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@Transactional
public class CustomerController {

    @Autowired
     CustomerService customerService;

    //@PostMapping
    @GetMapping
    public ResponseUtil getAll(){
        return new ResponseUtil("OK","Successfully Saved...!!",customerService.getAllCustomer());
    }
}
