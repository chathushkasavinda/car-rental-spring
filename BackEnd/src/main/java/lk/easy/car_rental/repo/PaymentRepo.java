package lk.easy.car_rental.repo;

import lk.easy.car_rental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
    @Query(value = "SELECT `date`, SUM(total) FROM Payment GROUP BY `date`",nativeQuery = true)
    List getDailyIncome() throws RuntimeException;

    @Query(value = "SELECT MONTH(`date`), SUM(total) FROM Payment GROUP BY MONTH(`date`)", nativeQuery = true)
    List getMonthlyIncome() throws RuntimeException;

    @Query(value = "SELECT YEAR(`date`), SUM(total) FROM Payment GROUP BY YEAR(`date`)", nativeQuery = true)
    List getYearlyIncome() throws RuntimeException;

    @Query(value = "SELECT SUM(total) FROM Payment WHERE MONTH(`date`)=MONTH(DATE(now()))", nativeQuery = true)
    BigDecimal getCurrentMonthIncome() throws RuntimeException;

    @Query(value = "SELECT SUM(total) FROM Payment WHERE `date`= DATE(now()) ", nativeQuery = true)
    BigDecimal getCurrentDayIncome() throws RuntimeException;

    @Query(value = "SELECT SUM(total) FROM Payment WHERE YEAR(`date`)=YEAR(DATE(now())) ", nativeQuery = true)
    BigDecimal getCurrentYearIncome() throws RuntimeException;
}
