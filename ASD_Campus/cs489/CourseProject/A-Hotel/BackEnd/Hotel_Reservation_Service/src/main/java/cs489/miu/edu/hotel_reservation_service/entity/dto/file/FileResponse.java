package cs489.miu.edu.hotel_reservation_service.entity.dto.file;

public record FileResponse(
        Integer id,
        String type,
        String name,
        String path
) {
}
