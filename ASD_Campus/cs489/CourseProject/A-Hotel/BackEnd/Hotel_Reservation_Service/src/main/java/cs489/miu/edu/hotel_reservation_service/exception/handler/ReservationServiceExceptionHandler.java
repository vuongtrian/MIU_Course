package cs489.miu.edu.hotel_reservation_service.exception.handler;

import cs489.miu.edu.hotel_reservation_service.entity.dto.APIResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.ErrorDTO;
import cs489.miu.edu.hotel_reservation_service.exception.ReservationNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.ReservationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class ReservationServiceExceptionHandler extends CustomizedExceptionHandler{
    @ExceptionHandler(ReservationServiceException.class)
    public APIResponse<?> handleReservationServiceException(ReservationServiceException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        return serviceResponse;
    }

    @ExceptionHandler(ReservationNotFoundException.class)
    public APIResponse<?> handleReservationNotFoundException (ReservationNotFoundException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        return serviceResponse;
    }
}
