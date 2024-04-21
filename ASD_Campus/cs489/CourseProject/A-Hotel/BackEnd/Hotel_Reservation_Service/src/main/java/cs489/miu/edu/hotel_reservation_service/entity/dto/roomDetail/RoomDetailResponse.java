package cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail;

import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomResponse;

import java.math.BigDecimal;
import java.util.List;

public record RoomDetailResponse(
        Integer id,
        String type,
        BigDecimal price,
        String bedType,
        Integer numberOfBeds,
        String description
//        List<RoomResponse> rooms,
//        List<FileResponse> images
) {
}
