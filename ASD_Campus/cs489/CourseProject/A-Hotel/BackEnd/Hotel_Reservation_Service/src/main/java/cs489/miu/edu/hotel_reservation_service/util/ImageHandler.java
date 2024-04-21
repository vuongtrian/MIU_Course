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
//    public static String getImageDirectory() {
//        String os = System.getProperty("os.name").toLowerCase();
//        String directory;
//        if (os.contains("win")) {
//            directory = "src\\main\\resources\\static\\images";
//        } else {
//            directory = "src/main/resources/static/images";
//        }
//        return directory;
//    }

//    public static FileRequest uploadImage (MultipartFile image) {
//        try {
//            String fileName =  UUID.randomUUID() + "_" + image.getOriginalFilename();
//            Path path = Paths.get(getImageDirectory(), fileName);
//            image.transferTo(new File(path.toFile().getAbsolutePath()));
//            return new FileRequest(image.getContentType(), fileName, path.toFile().getAbsolutePath());
//        } catch (IOException e) {
//            throw new FileDataServiceException("Failed to store image to local repo");
//        }
//    }
//
//    public static void deleteImage (String imagePath){
//        try {
//            String fileName = imagePath.substring(imagePath.lastIndexOf("/") + 1);
//            Path filePath = Paths.get(getImageDirectory(), fileName);
//            Files.deleteIfExists(filePath);
//        }catch (IOException e) {
//            throw new RuntimeException("Failed to delete image out of local repo", e);
//        }
//    }
}
