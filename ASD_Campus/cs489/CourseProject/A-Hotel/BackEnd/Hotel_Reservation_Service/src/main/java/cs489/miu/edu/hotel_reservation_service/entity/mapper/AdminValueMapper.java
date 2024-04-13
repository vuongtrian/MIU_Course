package cs489.miu.edu.hotel_reservation_service.entity.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.Admin;
import cs489.miu.edu.hotel_reservation_service.entity.dto.AdminRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.AdminResponseDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.CustomerRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.CustomerResponseDTO;

public class AdminValueMapper {
    public static Admin convertToEntity(AdminRequestDTO adminRequestDTO) {
        Admin admin = new Admin();
        admin.setUsername(adminRequestDTO.getUsername());
        admin.setPassword(adminRequestDTO.getPassword());
        admin.setEnabled(adminRequestDTO.getEnabled());
        admin.setFirstName(adminRequestDTO.getFirstName());
        admin.setLastName(adminRequestDTO.getLastName());
        admin.setPhoneNumber(adminRequestDTO.getPhoneNumber());
        admin.setEmail(adminRequestDTO.getEmail());
        admin.setRegion(adminRequestDTO.getRegion());
        return admin;
    }

    public static AdminResponseDTO convertToDTO(Admin admin) {
        AdminResponseDTO adminResponseDTO = new AdminResponseDTO();
        adminResponseDTO.setId(admin.getId());
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
