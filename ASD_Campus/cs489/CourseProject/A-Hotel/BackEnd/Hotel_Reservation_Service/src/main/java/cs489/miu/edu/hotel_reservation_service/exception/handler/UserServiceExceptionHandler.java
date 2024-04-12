package cs489.miu.edu.hotel_reservation_service.exception.handler;

import cs489.miu.edu.hotel_reservation_service.entity.dto.APIResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.ErrorDTO;
import cs489.miu.edu.hotel_reservation_service.exception.UserNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.UserServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
@RestControllerAdvice
public class UserServiceExceptionHandler extends CustomizedExceptionHandler{
    @ExceptionHandler(UserServiceException.class)
    public APIResponse<?> handleServiceExceptio(UserServiceException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        return serviceResponse;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public APIResponse<?> handleCustomerNotFoundException (UserNotFoundException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        return serviceResponse;
    }
}
