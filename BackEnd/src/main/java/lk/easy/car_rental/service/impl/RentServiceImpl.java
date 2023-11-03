package lk.easy.car_rental.service.impl;

import lk.easy.car_rental.dto.RentDTO;
import lk.easy.car_rental.entity.Car;
import lk.easy.car_rental.entity.Rent;
import lk.easy.car_rental.entity.RentDetail;
import lk.easy.car_rental.repo.DriverRepo;
import lk.easy.car_rental.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Driver;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    ModelMapper mapper;

    DriverRepo driverRepo;


    @Override
    public void requestRent(RentDTO rentDTO) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Rent rent = mapper.map(rentDTO, Rent.class);

        System.out.println(rent);

        if (rentDTO.getDriverRequest().equals("YES")) {

            List<Driver> drivers = driverRepo.getAvailableDrivers();
            int i;

            for (RentDetail rentDetail : rent.getRentDetails()) {

                i = new Random().nextInt(drivers.size());
                rentDetail.setNic(drivers.get(i).getNic());
                Car car = carRepo.findById(rentDetail.getRegNum()).get();
                car.setAvailability("NO");

                carRepo.save(car);

                drivers.get(i).setAvailabilityStatus("NO");
                driverRepo.save(drivers.get(i));
            }

        }

        rentRepo.save(rent);
    }

    @Override
    public String generateNewRentID() {
        return null;
    }

    @Override
    public List<RentDTO> getAllRents() {

    }

}
