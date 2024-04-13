package cs489.miu.edu.hotel_reservation_service.exception.handler;

import cs489.miu.edu.hotel_reservation_service.entity.dto.APIResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.ErrorDTO;
import cs489.miu.edu.hotel_reservation_service.exception.CustomerNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.CustomerServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
@RestControllerAdvice
public class CustomerServiceExceptionHandler extends CustomizedExceptionHandler{
    @ExceptionHandler(CustomerServiceException.class)
    public APIResponse<?> handleCustomerServiceException(CustomerServiceException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        return serviceResponse;
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public APIResponse<?> handleCustomerNotFoundException (CustomerNotFoundException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        return serviceResponse;
    }
}
