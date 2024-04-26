package cs489.miu.edu.hotel_reservation_service.service;

import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    FileResponse createImage(Integer roomDetailId, MultipartFile imageFile);
    FileResponse updateImage(Integer imageId, MultipartFile imageFile);
    void deleteImageById(Integer imageId);
    byte[] getImageById(Integer id);
    byte[] getImageByRoomDetailId(Integer roomDetailId);
}
