package lk.easy.car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentDetailDTO {
    private String rentId;
    private String regNum;
    private String nic;
    private BigDecimal driverCost;
    private BigDecimal carCost;
}
