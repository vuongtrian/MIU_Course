package cs489.miu.edu.hotel_reservation_service.exception;

public class RoomDetailNotFoundException extends RuntimeException{
    public RoomDetailNotFoundException(String message) {
        super(message);
    }
}
