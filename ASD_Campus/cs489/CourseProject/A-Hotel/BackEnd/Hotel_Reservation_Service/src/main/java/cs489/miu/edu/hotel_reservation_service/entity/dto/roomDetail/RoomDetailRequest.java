package cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail;

import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomRequest;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public record RoomDetailRequest(
        String type,
        BigDecimal price,
        String bedType,
        Integer numberOfBeds,
        String description,
        List<RoomRequest> rooms,
        List<MultipartFile> images
) {
}
