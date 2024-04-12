package cs489.miu.edu.hotel_reservation_service.entity.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.Admin;
import cs489.miu.edu.hotel_reservation_service.entity.Customer;
import cs489.miu.edu.hotel_reservation_service.entity.User;
import cs489.miu.edu.hotel_reservation_service.entity.dto.UserRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.UserResponseDTO;

public class UserValueMapper {
    public static Customer convertCustomerToEntity(UserRequestDTO userRequestDTO) {
        Customer customer = new Customer();
        customer.setUsername(userRequestDTO.getUsername());
        customer.setPassword(userRequestDTO.getPassword());
        customer.setEnabled(userRequestDTO.getEnabled());
        customer.setFirstName(userRequestDTO.getFirstName());
        customer.setLastName(userRequestDTO.getLastName());
        customer.setPhoneNumber(userRequestDTO.getPhoneNumber());
        customer.setEmail(userRequestDTO.getEmail());
        customer.setAddress(userRequestDTO.getAddress());
        customer.setCreditCard(userRequestDTO.getCreditCard());
        return customer;
    }

    public static UserResponseDTO convertCustomerToDTO(Customer customer) {
        UserResponseDTO customerResponseDTO = new UserResponseDTO();
        customerResponseDTO.setId(customer.getId());
        customerResponseDTO.setRole("customer");
        customerResponseDTO.setUsername(customer.getUsername());
        customerResponseDTO.setEnable(customer.getEnabled());
        customerResponseDTO.setFirstName(customer.getFirstName());
        customerResponseDTO.setLastName(customer.getLastName());
        customerResponseDTO.setPhoneNumber(customer.getPhoneNumber());
        customerResponseDTO.setEmail(customer.getEmail());
        customerResponseDTO.setAddress(customer.getAddress());
        customerResponseDTO.setCreditCard(customer.getCreditCard());
        return customerResponseDTO;
    }

    public static Admin convertAdminToEntity(UserRequestDTO userRequestDTO) {
        Admin admin = new Admin();
        admin.setUsername(userRequestDTO.getUsername());
        admin.setPassword(userRequestDTO.getPassword());
        admin.setEnabled(userRequestDTO.getEnabled());
        admin.setFirstName(userRequestDTO.getFirstName());
        admin.setLastName(userRequestDTO.getLastName());
        admin.setPhoneNumber(userRequestDTO.getPhoneNumber());
        admin.setEmail(userRequestDTO.getEmail());
        admin.setRegion(userRequestDTO.getRegion());
        return admin;
    }

    public static UserResponseDTO convertAdminToDTO(Admin admin) {
        UserResponseDTO adminResponseDTO = new UserResponseDTO();
        adminResponseDTO.setId(admin.getId());
        adminResponseDTO.setRole("admin");
        adminResponseDTO.setUsername(admin.getUsername());
        adminResponseDTO.setEnable(admin.getEnabled());
        adminResponseDTO.setFirstName(admin.getFirstName());
        adminResponseDTO.setLastName(admin.getLastName());
        adminResponseDTO.setPhoneNumber(admin.getPhoneNumber());
        adminResponseDTO.setEmail(admin.getEmail());
        adminResponseDTO.setRegion(admin.getRegion());
        return adminResponseDTO;
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
