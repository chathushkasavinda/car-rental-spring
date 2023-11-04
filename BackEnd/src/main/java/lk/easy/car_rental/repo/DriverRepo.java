package lk.easy.car_rental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Driver;
import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String > {
    @Query(value = "SELECT * FROM Driver WHERE availabilityStatus='YES'", nativeQuery = true)
    List<lk.easy.car_rental.entity.Driver> getAvailableDrivers() throws RuntimeException;

    @Query(value = "SELECT * FROM Driver WHERE user_username=?", nativeQuery = true)
    lk.easy.car_rental.entity.Driver getDriverByUsername(String username);

    @Query(value = "SELECT COUNT(nic) FROM Driver WHERE availabilityStatus='YES'", nativeQuery = true)
    Long countAvailableDrivers() throws RuntimeException;

    @Query(value = "SELECT COUNT(nic) FROM Driver WHERE availabilityStatus='NO'", nativeQuery = true)
    Long countReservedDrivers() throws RuntimeException;
}
