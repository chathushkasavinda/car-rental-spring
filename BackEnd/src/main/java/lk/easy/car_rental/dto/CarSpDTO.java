package lk.easy.car_rental.dto;

import lk.easy.car_rental.embedded.CarPhoto;
import lk.easy.car_rental.embedded.FreeMileage;
import lk.easy.car_rental.embedded.Price;

import java.math.BigDecimal;

public class CarSpDTO {
    private String regNum;
    private String type;
    private String color;
    private String brand;
    private String Availability;
    private String transmissionType;
    private String fuelType;
    private int passengers;
    private Price price;
    private FreeMileage freeMileage;
    private BigDecimal extraKMPrice;
    private BigDecimal lostDamageCost;
    private String meterValue;
    private CarPhoto photos;
}
