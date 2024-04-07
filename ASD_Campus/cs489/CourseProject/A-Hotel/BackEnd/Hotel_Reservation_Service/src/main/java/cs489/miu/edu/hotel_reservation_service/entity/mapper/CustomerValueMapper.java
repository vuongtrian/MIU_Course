package cs489.miu.edu.hotel_reservation_service.entity.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.Customer;
import cs489.miu.edu.hotel_reservation_service.entity.dto.CustomerRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.CustomerResponseDTO;

public class CustomerValueMapper {
    public static Customer convertToEntity(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer();
        customer.setFirstName(customerRequestDTO.getFirstName());
        customer.setLastName(customerRequestDTO.getLastName());
        customer.setPhoneNumber(customerRequestDTO.getPhoneNumber());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setAddress(customerRequestDTO.getAddress());
        customer.setCreditCard(customerRequestDTO.getCreditCard());
        return customer;
    }

    public static CustomerResponseDTO convertToDTO(Customer customer) {
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setId(customer.getId());
        customerResponseDTO.setFirstName(customer.getFirstName());
        customerResponseDTO.setLastName(customer.getLastName());
        customerResponseDTO.setPhoneNumber(customer.getPhoneNumber());
        customerResponseDTO.setEmail(customer.getEmail());
        customerResponseDTO.setAddress(customer.getAddress());
        customerResponseDTO.setCreditCard(customer.getCreditCard());
        return customerResponseDTO;
    }

    public static String jsonAsString(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
