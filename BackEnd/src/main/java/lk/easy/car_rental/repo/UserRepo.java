package lk.easy.car_rental.repo;

import lk.easy.car_rental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String > {

}
