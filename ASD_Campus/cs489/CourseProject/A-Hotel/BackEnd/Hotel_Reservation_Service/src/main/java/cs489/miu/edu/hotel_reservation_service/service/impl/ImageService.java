package cs489.miu.edu.hotel_reservation_service.service.impl;

import cs489.miu.edu.hotel_reservation_service.entity.FileData;
import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataResponseDTO;
import cs489.miu.edu.hotel_reservation_service.entity.mapper.FileDataValueMapper;
import cs489.miu.edu.hotel_reservation_service.exception.FileDataNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.FileDataServiceException;
import cs489.miu.edu.hotel_reservation_service.repository.IFileDataRepository;
import cs489.miu.edu.hotel_reservation_service.service.IImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements IImageService {
    private IFileDataRepository fileDataRepository;
    @Override
    public FileDataResponseDTO createImage(FileDataRequestDTO fileDataRequestDTO) {
        try {
            FileData image = fileDataRepository.save(FileDataValueMapper.convertToEntity(fileDataRequestDTO));
            return FileDataValueMapper.convertToDTO(image);
        } catch (Exception e) {
            throw new FileDataServiceException("Exception occurred while save a new image to database");
        }
    }

    @Override
    public FileDataResponseDTO getImageById(Integer id) {
        try {
            FileData image = fileDataRepository.findById(id)
                    .orElseThrow(() -> new FileDataNotFoundException("Image not found with id " + id));
            return FileDataValueMapper.convertToDTO(image);
        } catch (Exception e) {
            throw new FileDataServiceException("Exception occurred while fetch image id " + id + " from database");
        }
    }

    @Override
    public void deleteImage(Integer id) {
        try {
            FileData image = fileDataRepository.findById(id)
                    .orElseThrow(() -> new FileDataNotFoundException("Image not found with id " + id));
            fileDataRepository.deleteById(id);
        } catch (Exception e) {
            throw new FileDataServiceException("Exception occurred while delete image id " + id + " from database");
        }
    }

    @Override
    public FileDataResponseDTO updateImage(Integer id, FileDataRequestDTO fileDataRequestDTO) {
        try {
            FileData image = fileDataRepository.findById(id)
                    .orElseThrow(() -> new FileDataNotFoundException("Image not found with id " + id));
            image.setType(fileDataRequestDTO.getType());
            image.setName(fileDataRequestDTO.getName());
            image.setPath(fileDataRequestDTO.getPath());
            FileData updatedImage= fileDataRepository.save(image);
            return FileDataValueMapper.convertToDTO(updatedImage);
        } catch (Exception e) {
            throw new FileDataServiceException("Exception occurred while update image id " + id + " from database");
        }
    }
}
