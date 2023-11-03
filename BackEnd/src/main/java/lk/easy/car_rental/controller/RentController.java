package lk.easy.car_rental.controller;

import lk.easy.car_rental.service.RentService;
import lk.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent")
@CrossOrigin
public class RentController {

    RentService rentService;

    public ResponseUtil generateNewRentID(){

        return new ResponseUtil("Ok","Successfully Requseted","");
    }
}
