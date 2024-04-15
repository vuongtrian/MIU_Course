package cs489.miu.edu.hotel_reservation_service.entity.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.FileData;
import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataResponseDTO;

public class FileDataValueMapper {
    public static FileData convertToEntity (FileDataRequestDTO fileDataRequestDTO) {
        FileData fileData = new FileData();
        fileData.setType(fileDataRequestDTO.getType());
        fileData.setName(fileDataRequestDTO.getName());
        fileData.setPath(fileDataRequestDTO.getPath());
        return fileData;
    }


    public static FileDataResponseDTO convertToDTO (FileData fileData) {
        FileDataResponseDTO fileDataResponseDTO = new FileDataResponseDTO();
        fileDataResponseDTO.setId(fileData.getId());
        fileDataResponseDTO.setType(fileData.getType());
        fileDataResponseDTO.setName(fileData.getName());
        fileDataResponseDTO.setPath(fileData.getPath());
        return fileDataResponseDTO;
    }

    public static String jsonAsString(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
