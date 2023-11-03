package lk.easy.car_rental.service.impl;

import lk.easy.car_rental.dto.PaymentDTO;
import lk.easy.car_rental.entity.Payment;
import lk.easy.car_rental.entity.Rent;
import lk.easy.car_rental.repo.PaymentRepo;
import lk.easy.car_rental.repo.RentRepo;
import lk.easy.car_rental.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    PaymentRepo paymentRepo;

    RentRepo rentRepo;

    ModelMapper mapper;

    @Override
    public void savePayment(PaymentDTO paymentDTO) throws RuntimeException {
        Payment payment = mapper.map(paymentDTO, Payment.class);
        Rent rent = rentRepo.findById(paymentDTO.getRentId().getRentId()).get();
        payment.setRentId(rent);
        payment.setDate(LocalDate.now());
        payment.setTime(LocalTime.now());
        paymentRepo.save(payment);
    }

    @Override
    public List<PaymentDTO> loadAllPayments() throws RuntimeException {
        return mapper.map(paymentRepo.findAll(), new TypeToken<ArrayList<PaymentDTO>>() {
        }.getType());
    }
}
