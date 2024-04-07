package cs489.miu.edu.hotel_reservation_service.exception;

public class CustomerServiceException extends RuntimeException{
    public CustomerServiceException(String message) {
        super(message);
    }
}
