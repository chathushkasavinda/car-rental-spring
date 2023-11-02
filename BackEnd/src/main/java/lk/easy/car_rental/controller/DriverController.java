package lk.easy.car_rental.controller;

import lk.easy.car_rental.dto.DriverDTO;
import lk.easy.car_rental.dto.UserDTO;
import lk.easy.car_rental.service.DriverService;
import lk.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
    //@Autowired
    DriverService driverService;

    @PostMapping
    public ResponseUtil saveDriver(@RequestParam String username, @RequestParam String password, DriverDTO driverDTO){
        driverDTO.setUser(new UserDTO(username,password,"Driver"));
        driverService.saveDriver(driverDTO);
        return new ResponseUtil("OK","Successfully Saved..!","");
    }

    @GetMapping("/all")
    public ResponseUtil getAll(){
        return new ResponseUtil("OK","Successfully Loaded..!","");
    }

    @PostMapping("/update")
    public ResponseUtil updateDriver(@RequestParam String username,@RequestParam String password,@ModelAttribute DriverDTO driverDTO){
        driverDTO.setUser(new UserDTO(username,password,"Driver"));
        driverService.updateDriver(driverDTO);
        return new ResponseUtil("OK","Successfully Updated..!","");
    }

    @DeleteMapping()
    public ResponseUtil deleteDriver(@RequestParam String username,@RequestParam String password,@ModelAttribute DriverDTO driverDTO){
        driverDTO.setUser(new UserDTO(username,password,"Driver"));
        driverService.updateDriver(driverDTO);
        return new ResponseUtil("OK","Successfully Deleted..!","");
    }

}
