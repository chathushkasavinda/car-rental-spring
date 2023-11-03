package lk.easy.car_rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Driver;
import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String > {
    @Query(value = "SELECT * FROM Driver WHERE availabilityStatus='YES'", nativeQuery = true)
    List<Driver> getAvailableDrivers() throws RuntimeException;
}
