package cs489.miu.edu.hotel_reservation_service.exception.handler;

import cs489.miu.edu.hotel_reservation_service.entity.dto.APIResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.ErrorDTO;
import cs489.miu.edu.hotel_reservation_service.exception.RoomDetailNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.RoomDetailServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class RoomDetailServiceExceptionHandler extends CustomizedExceptionHandler{
    @ExceptionHandler(RoomDetailServiceException.class)
    public APIResponse<?> handleServiceException(RoomDetailServiceException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        return serviceResponse;
    }

    @ExceptionHandler(RoomDetailNotFoundException.class)
    public APIResponse<?> handleReservationNotFoundException (RoomDetailNotFoundException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        return serviceResponse;
    }
}
