package cs489.miu.edu.hotel_reservation_service.service;

import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataResponseDTO;

public interface IImageService {
    FileDataResponseDTO createImage(FileDataRequestDTO fileDataRequestDTO);
    FileDataResponseDTO getImageById(Integer id);
    void deleteImage(Integer id);
    FileDataResponseDTO updateImage(Integer id, FileDataRequestDTO fileDataRequestDTO);
}
