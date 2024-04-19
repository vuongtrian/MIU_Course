package cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.RoomDetail;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileValueMapper;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomValueMapper;

public class RoomDetailValueMapper {
    public static RoomDetail convertToEntity(RoomDetailRequest roomDetailRequest) {
        return new RoomDetail(
                roomDetailRequest.type(),
                roomDetailRequest.price(),
                roomDetailRequest.bedType(),
                roomDetailRequest.numberOfBeds(),
                roomDetailRequest.description(),
                roomDetailRequest.rooms().stream().map(
                        RoomValueMapper::convertToEntity
                ).toList(),
                roomDetailRequest.images().stream().map(
                        FileValueMapper::convertToEntity
                ).toList()
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
                roomDetail.getRooms().stream().map(
                        RoomValueMapper::convertToDto
                ).toList(),
                roomDetail.getImages().stream().map(
                        FileValueMapper::convertToDto
                ).toList()
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
