package cs489.miu.edu.hotel_reservation_service.Util;

import cs489.miu.edu.hotel_reservation_service.configuration.ImageConfig;
import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageHandler {
    private ImageConfig imageConfig;

    public FileDataRequestDTO uploadImage (MultipartFile image){
        FileDataRequestDTO imageRequestDTO = new FileDataRequestDTO();
        try {
            String fileName =  UUID.randomUUID() + "_" + image.getOriginalFilename();
            String filePath = imageConfig +fileName;
            imageRequestDTO.setType(image.getContentType());
            imageRequestDTO.setName(fileName);
            imageRequestDTO.setPath(filePath);
            image.transferTo(new File(filePath));
            return imageRequestDTO;
        } catch (IOException e) {
            throw new RuntimeException("Failed to store image to local repo", e);
        }
    }

    public void deleteImage (String imagePath){
        try {
            String fileName = imagePath.substring(imagePath.lastIndexOf("/") + 1);
            Path filePath = Paths.get(imageConfig.getAbsoluteImageUploadPath(), fileName);
            Files.deleteIfExists(filePath);
        }catch (IOException e) {
            throw new RuntimeException("Failed to delete image out of local repo", e);
        }
    }
}
