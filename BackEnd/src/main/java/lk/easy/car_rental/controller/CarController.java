package lk.easy.car_rental.controller;

import lk.easy.car_rental.dto.CarDTO;
import lk.easy.car_rental.dto.CarPhotoDTO;
import lk.easy.car_rental.embedded.FreeMileage;
import lk.easy.car_rental.embedded.Price;
import lk.easy.car_rental.service.CarService;
import lk.easy.car_rental.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    CarService carService;
    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarPhotoDTO carPhotoDTO, @ModelAttribute Price price, @ModelAttribute FreeMileage freeMileage, @ModelAttribute CarDTO carDTO) {
        carDTO.setPhotos(carPhotoDTO);
        carDTO.setPrice(price);
        carDTO.setFreeMileage(freeMileage);

        carService.saveCar(carDTO);

        return new ResponseUtil("OK", "Successfully Saved..!", "");

    }
}
