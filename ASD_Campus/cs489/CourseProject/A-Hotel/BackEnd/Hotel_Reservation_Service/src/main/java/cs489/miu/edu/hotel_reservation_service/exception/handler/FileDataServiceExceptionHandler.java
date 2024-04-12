package cs489.miu.edu.hotel_reservation_service.exception.handler;

import cs489.miu.edu.hotel_reservation_service.entity.dto.APIResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.ErrorDTO;
import cs489.miu.edu.hotel_reservation_service.exception.FileDataNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.FileDataServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class FileDataServiceExceptionHandler extends CustomizedExceptionHandler{
    @ExceptionHandler(FileDataServiceException.class)
    public APIResponse<?> handleServiceException(FileDataServiceException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        return serviceResponse;
    }

    @ExceptionHandler(FileDataNotFoundException.class)
    public APIResponse<?> handleReservationNotFoundException (FileDataNotFoundException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        return serviceResponse;
    }
}
