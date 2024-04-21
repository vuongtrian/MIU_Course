package cs489.miu.edu.hotel_reservation_service.service;

import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {
    FileResponse createImage(Integer roomDetailId, MultipartFile imageFile);
    FileResponse updateImage(Integer imageId, MultipartFile imageFile);
    void deleteImageById(Integer imageId);
    byte[] getImageById(Integer id);
}
