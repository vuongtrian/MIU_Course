package cs489.miu.edu.hotel_reservation_service.exception;

public class UserServiceException extends RuntimeException{
    public UserServiceException(String message) {
        super(message);
    }
}
