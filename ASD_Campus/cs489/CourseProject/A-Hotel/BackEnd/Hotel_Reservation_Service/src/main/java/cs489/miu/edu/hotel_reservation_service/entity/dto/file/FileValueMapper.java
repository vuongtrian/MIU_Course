package cs489.miu.edu.hotel_reservation_service.entity.dto.file;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.FileData;

public class FileValueMapper {
    public static FileData convertToEntity (FileRequest fileRequest) {
        return new FileData(
                fileRequest.type(),
                fileRequest.name(),
                fileRequest.path()
        );
    }

    public static FileResponse convertToDto (FileData fileData) {
        return new FileResponse(
                fileData.getId(),
                fileData.getType(),
                fileData.getName(),
                fileData.getPath()
        );
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
