package lk.easy.car_rental.dto;

import org.springframework.web.multipart.MultipartFile;

public class CarPhotoDTO {
    private MultipartFile front;
    private MultipartFile back;
    private MultipartFile side;
    private MultipartFile interior;
}
