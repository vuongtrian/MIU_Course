package cs489.miu.edu.hotel_reservation_service.entity.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.FileData;
import cs489.miu.edu.hotel_reservation_service.entity.RoomDetail;
import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataResponseDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.RoomDetailRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.RoomDetailResponseDTO;

import java.util.List;

public class RoomDetailValueMapper {
    public static RoomDetail convertToEntity (RoomDetailRequestDTO roomDetailRequestDTO) {
        RoomDetail roomDetail = new RoomDetail();
        roomDetail.setType(roomDetailRequestDTO.getType());
        roomDetail.setPrice(roomDetailRequestDTO.getPrice());
        roomDetail.setBedType(roomDetailRequestDTO.getBedType());
        roomDetail.setNumberOfBeds(roomDetailRequestDTO.getNumberOfBeds());
        roomDetail.setDescription(roomDetailRequestDTO.getDescription());
        if(roomDetailRequestDTO.getImages() != null) {
            List<FileData> images = roomDetailRequestDTO.getImages()
                    .stream()
                    .map(FileDataValueMapper::convertToEntity)
                    .toList();
            roomDetail.setImages(images);
        }
        return roomDetail;
    }

    public static RoomDetailResponseDTO convertToDTO (RoomDetail roomDetail) {
        RoomDetailResponseDTO roomDetailResponseDTO = new RoomDetailResponseDTO();
        roomDetailResponseDTO.setType(roomDetail.getType());
        roomDetailResponseDTO.setPrice(roomDetail.getPrice());
        roomDetailResponseDTO.setBedType(roomDetail.getBedType());
        roomDetailResponseDTO.setNumberOfBeds(roomDetail.getNumberOfBeds());
        roomDetailResponseDTO.setDescription(roomDetail.getDescription());
        if(roomDetail.getImages() != null) {
            List<FileDataResponseDTO> images = roomDetail.getImages()
                    .stream()
                    .map(FileDataValueMapper::convertToDTO)
                    .toList();
            roomDetailResponseDTO.setImages(images);
        }
        return roomDetailResponseDTO;
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
