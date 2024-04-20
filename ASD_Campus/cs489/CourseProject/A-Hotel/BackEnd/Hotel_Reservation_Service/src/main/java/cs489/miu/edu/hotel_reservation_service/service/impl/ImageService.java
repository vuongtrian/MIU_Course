package cs489.miu.edu.hotel_reservation_service.service.impl;

import cs489.miu.edu.hotel_reservation_service.entity.FileData;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileValueMapper;
import cs489.miu.edu.hotel_reservation_service.exception.FileDataNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.FileDataServiceException;
import cs489.miu.edu.hotel_reservation_service.repository.IFileDataRepository;
import cs489.miu.edu.hotel_reservation_service.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements IImageService {
    @Autowired
    private IFileDataRepository fileDataRepository;

    @Override
    public FileResponse getImageById(Integer id) {
        try {
            FileData image = fileDataRepository.findById(id)
                    .orElseThrow(() -> new FileDataNotFoundException("Image not found with id " + id));
            return FileValueMapper.convertToDto(image);
        } catch (Exception e) {
            throw new FileDataServiceException("Exception occurred while fetch image id " + id + " from database");
        }
    }
}
