package cs489.miu.edu.hotel_reservation_service.service;

import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataResponseDTO;

import java.util.List;

public interface IFileDataService {
    FileDataResponseDTO saveFile(FileDataRequestDTO fileDataRequestDTO);
    List<FileDataResponseDTO> getAllFile();
    FileDataResponseDTO getFileById(Integer id);
    void deleteFile(Integer id);
}
