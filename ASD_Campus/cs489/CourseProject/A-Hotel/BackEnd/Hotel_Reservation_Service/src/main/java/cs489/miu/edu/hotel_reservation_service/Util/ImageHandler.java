package cs489.miu.edu.hotel_reservation_service.Util;

import cs489.miu.edu.hotel_reservation_service.configuration.ImageConfig;
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

    public String uploadImage (MultipartFile file) {
        try {
            String fileName =  UUID.randomUUID() + "_" + file.getOriginalFilename();
            String filePath = imageConfig +fileName;
            file.transferTo(new File(filePath));
            return filePath;
        } catch (IOException e) {
            throw new RuntimeException("Failed to store image", e);
        }
    }

    public void deleteImage (String imagePath) {
        try {
            String fileName = imagePath.substring(imagePath.lastIndexOf("/") + 1);
            Path filePath = Paths.get(imageConfig.getAbsoluteImageUploadPath(), fileName);
            Files.deleteIfExists(filePath);
        }catch (IOException e) {
            throw new RuntimeException("Failed to delete image", e);
        }
    }
}
