package cs489.miu.edu.hotel_reservation_service.service;

import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileResponse;

public interface IImageService {
    FileResponse getImageById(Integer id);

}
