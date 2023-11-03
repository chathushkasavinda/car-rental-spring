package lk.easy.car_rental.service.impl;

import lk.easy.car_rental.dto.CustomerDTO;
import lk.easy.car_rental.dto.RentDTO;
import lk.easy.car_rental.dto.RentDetailDTO;
import lk.easy.car_rental.entity.Car;
import lk.easy.car_rental.entity.Rent;
import lk.easy.car_rental.entity.RentDetail;
import lk.easy.car_rental.repo.CarRepo;
import lk.easy.car_rental.repo.CustomerRepo;
import lk.easy.car_rental.repo.DriverRepo;
import lk.easy.car_rental.repo.RentRepo;
import lk.easy.car_rental.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    ModelMapper mapper;

    DriverRepo driverRepo;

    CarRepo carRepo;

    RentDetail rentDetail;

    RentRepo rentRepo;

    CustomerRepo customerRepo;

    @Override
    public void requestRent(RentDTO rentDTO) throws RuntimeException{
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Rent rent = mapper.map(rentDTO, Rent.class);

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
        String lastRentId = rentRepo.getLastRentId();
        return lastRentId != null ? String.format("RID-%03d", (Integer.parseInt(lastRentId.replace("RID-", "")) + 1)) : "RID-001";
    }

    @Override
    public List<RentDTO> getAllRents() {
        return mapper.map(rentRepo.findAll(), new TypeToken<ArrayList<RentDTO>>() {
        }.getType());

    }

    @Override
    public void acceptRentRequest(String rentId, String option) throws RuntimeException {

    }

    @Override
    public RentDTO getRentByRentId(String rentId) throws RuntimeException {
        return null;
    }

    @Override
    public List<RentDetailDTO> getDriverSchedule(String nic) throws RuntimeException {
        return null;
    }

    @Override
    public List<RentDTO> getRentByNic(String nic) throws RuntimeException {
        return null;
    }

    @Override
    public Long countRents() throws RuntimeException {
        return null;
    }

    @Override
    public CustomerDTO getCustomerByUsername(String username) throws RuntimeException {
        return null;
    }

}
