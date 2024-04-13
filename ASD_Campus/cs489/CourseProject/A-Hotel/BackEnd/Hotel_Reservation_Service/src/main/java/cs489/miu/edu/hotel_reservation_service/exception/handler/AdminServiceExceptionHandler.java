package cs489.miu.edu.hotel_reservation_service.exception.handler;

import cs489.miu.edu.hotel_reservation_service.entity.dto.APIResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.ErrorDTO;
import cs489.miu.edu.hotel_reservation_service.exception.AdminNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.AdminServiceException;
import cs489.miu.edu.hotel_reservation_service.exception.CustomerNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.CustomerServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class AdminServiceExceptionHandler extends CustomizedExceptionHandler{
    @ExceptionHandler(AdminServiceException.class)
    public APIResponse<?> handleAdminServiceException(AdminServiceException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        return serviceResponse;
    }

    @ExceptionHandler(AdminNotFoundException.class)
    public APIResponse<?> handleAdminNotFoundException (AdminNotFoundException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        return serviceResponse;
    }
}
