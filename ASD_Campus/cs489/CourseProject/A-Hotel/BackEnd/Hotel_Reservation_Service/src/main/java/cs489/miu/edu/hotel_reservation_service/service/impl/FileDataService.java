package cs489.miu.edu.hotel_reservation_service.service.impl;

import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataResponseDTO;
import cs489.miu.edu.hotel_reservation_service.repository.IFileDataRepository;
import cs489.miu.edu.hotel_reservation_service.service.IFileDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileDataService implements IFileDataService {
    private IFileDataRepository fileDataRepository;

    /*
    * store file to local folder
    * store file data properties to database
    * */
    @Override
    public FileDataResponseDTO saveFile(FileDataRequestDTO fileDataRequestDTO) {
        return null;
    }

    @Override
    public List<FileDataResponseDTO> getAllFile() {
        return List.of();
    }

    @Override
    public FileDataResponseDTO getFileById(Integer id) {
        return null;
    }

    @Override
    public void deleteFile(Integer id) {

    }
}
