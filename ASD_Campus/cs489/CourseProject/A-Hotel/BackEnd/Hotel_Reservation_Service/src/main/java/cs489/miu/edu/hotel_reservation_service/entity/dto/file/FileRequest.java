package cs489.miu.edu.hotel_reservation_service.entity.dto.file;

import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailRequest;

public record FileRequest(
        String type,
        String name,
        String path,
        RoomDetailRequest roomDetailRequest
) {
}
