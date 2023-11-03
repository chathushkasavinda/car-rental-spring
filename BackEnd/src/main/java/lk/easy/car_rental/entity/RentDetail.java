package lk.easy.car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@ToString
public class RentDetail {
    @Id
    private String rentId;
    @Id
    private String regNum;
    private String nic;
    private BigDecimal driverCost;
    private BigDecimal carCost;

    @ManyToOne
    @JoinColumn(name = "rentId", referencedColumnName = "rentId", insertable = false, updatable = false)
    private Rent rent;
}
