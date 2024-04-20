package cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.RoomDetail;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileValueMapper;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomValueMapper;
import cs489.miu.edu.hotel_reservation_service.util.ImageHandler;

import java.util.ArrayList;
import java.util.Collections;


public class RoomDetailValueMapper {

    public static RoomDetail convertToEntity(RoomDetailRequest roomDetailRequest) {
        return new RoomDetail(
                roomDetailRequest.type(),
                roomDetailRequest.price(),
                roomDetailRequest.bedType(),
                roomDetailRequest.numberOfBeds(),
                roomDetailRequest.description(),
                roomDetailRequest.rooms() == null ?
                        new ArrayList<>() :
                        roomDetailRequest.rooms().stream().map(RoomValueMapper::convertToEntity).toList(),
                roomDetailRequest.images() == null ?
                        Collections.emptyList() :
                        roomDetailRequest.images().stream().map(multipartFile -> {
                            FileRequest fileRequest = ImageHandler.uploadImage(multipartFile);
                            return FileValueMapper.convertToEntity(fileRequest);
                        }).toList()

        );

    }

    public static RoomDetailResponse convertToDto(RoomDetail roomDetail) {
        return new RoomDetailResponse(
                roomDetail.getId(),
                roomDetail.getType(),
                roomDetail.getPrice(),
                roomDetail.getBedType(),
                roomDetail.getNumberOfBeds(),
                roomDetail.getDescription(),
                roomDetail.getRooms().isEmpty() ?
                        new ArrayList<>() :
                        roomDetail.getRooms().stream().map(RoomValueMapper::convertToDto).toList(),
                roomDetail.getImages().isEmpty() ?
                        new ArrayList<>() :
                        roomDetail.getImages().stream().map(FileValueMapper::convertToDto).toList()
        );
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
