package cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail;

import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomRequest;

import java.math.BigDecimal;
import java.util.List;

public record RoomDetailRequest(
        String type,
        BigDecimal price,
        String bedType,
        Integer numberOfBeds,
        String description,
        List<RoomRequest> rooms,
        List<FileRequest> images
) {
}
