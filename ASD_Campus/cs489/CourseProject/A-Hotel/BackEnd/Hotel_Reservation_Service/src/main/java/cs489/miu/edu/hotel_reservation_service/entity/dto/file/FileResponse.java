package cs489.miu.edu.hotel_reservation_service.entity.dto.file;

import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailResponse;

public record FileResponse(
        Integer id,
        String type,
        String name,
        String path,
        RoomDetailResponse roomDetailResponse
) {
}
