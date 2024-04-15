package cs489.miu.edu.hotel_reservation_service.service;


import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    FileDataResponseDTO saveImage(MultipartFile image);
    FileDataResponseDTO getImageById(Integer id);
    void deleteImage(Integer id);
    FileDataResponseDTO updateImage(Integer id, MultipartFile image);
}
