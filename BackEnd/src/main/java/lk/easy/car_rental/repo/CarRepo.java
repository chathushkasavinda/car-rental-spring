package lk.easy.car_rental.repo;

import lk.easy.car_rental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,String > {

}
