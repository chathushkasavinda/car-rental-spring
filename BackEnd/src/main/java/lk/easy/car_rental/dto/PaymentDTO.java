package lk.easy.car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PaymentDTO {
    Integer paymentId;
    RentDTO rentId;
    String type;
    String description;
    LocalDate date;
    LocalTime time;
    BigDecimal total;
    BigDecimal cash;
    BigDecimal balance;
}
