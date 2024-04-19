package cs489.miu.edu.hotel_reservation_service.util;

import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileRequest;
import cs489.miu.edu.hotel_reservation_service.exception.FileDataServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class ImageHandler {
    public static String IMAGE_PATH = "src/main/resources/static/images";

    public static FileRequest uploadImage (MultipartFile image) {
        try {
            String fileName =  UUID.randomUUID() + "_" + image.getOriginalFilename();
            String filePath = IMAGE_PATH + "/" +fileName;
            image.transferTo(new File(filePath));
            return new FileRequest(image.getContentType(), fileName, filePath);
        } catch (IOException e) {
            throw new FileDataServiceException("Failed to store image to local repo");
        }
    }

    public static void deleteImage (String imagePath){
        try {
            String fileName = imagePath.substring(imagePath.lastIndexOf("/") + 1);
            Path filePath = Paths.get(IMAGE_PATH, fileName);
            Files.deleteIfExists(filePath);
        }catch (IOException e) {
            throw new RuntimeException("Failed to delete image out of local repo", e);
        }
    }
}
