package lk.easy.car_rental.controller;

import lk.easy.car_rental.dto.PaymentDTO;
import lk.easy.car_rental.service.PaymentService;
import lk.easy.car_rental.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {
    PaymentService paymentService;

    @PostMapping
    public ResponseUtil savePayment(@RequestParam PaymentDTO paymentDTO){
        paymentService.savePayment(paymentDTO);
        System.out.println(paymentDTO);
        return new ResponseUtil("OK", "Successfully Saved..!", "");
    }
}
