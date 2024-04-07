package cs489.miu.edu.hotel_reservation_service.exception;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException(String message) {
        super(message);
    }
}
