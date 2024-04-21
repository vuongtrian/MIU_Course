package cs489.miu.edu.hotel_reservation_service.service.impl;

import cs489.miu.edu.hotel_reservation_service.entity.FileData;
import cs489.miu.edu.hotel_reservation_service.entity.RoomDetail;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileValueMapper;
import cs489.miu.edu.hotel_reservation_service.exception.FileDataNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.FileDataServiceException;
import cs489.miu.edu.hotel_reservation_service.exception.RoomDetailNotFoundException;
import cs489.miu.edu.hotel_reservation_service.repository.IFileDataRepository;
import cs489.miu.edu.hotel_reservation_service.repository.IRoomDetailRepository;
import cs489.miu.edu.hotel_reservation_service.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageService implements IImageService {
    @Autowired
    private IFileDataRepository fileDataRepository;
    @Autowired
    private IRoomDetailRepository roomDetailRepository;

    @Override
    public FileResponse createImage(Integer roomDetailId, MultipartFile imageFile) {
        try {
            String fileName =  UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
            Path path = Paths.get(getImageDirectory(), fileName);
            imageFile.transferTo(new File(path.toFile().getAbsolutePath()));
            RoomDetail roomDetail = roomDetailRepository.findById(roomDetailId)
                    .orElseThrow(() -> new RoomDetailNotFoundException("Room detail not found with id " + roomDetailId));
            FileData image = new FileData(
                    imageFile.getContentType(),
                    fileName,
                    path.toFile().getAbsolutePath(),
                    roomDetail
            );
            fileDataRepository.save(image);

            return FileValueMapper.convertToDto(image);
        } catch (Exception e) {
            throw new FileDataServiceException("Exception occurred while create image");
        }
    }

    @Override
    public FileResponse updateImage(Integer imageId, MultipartFile imageFile) {
        try {
            FileData image = fileDataRepository.findById(imageId)
                    .orElseThrow(() -> new FileDataNotFoundException("Image not found with id " + imageId));
            String imagePath = image.getPath();
            String fileName = imagePath.substring(imagePath.lastIndexOf("/") + 1);
            Path filePath = Paths.get(getImageDirectory(), fileName);
            Files.deleteIfExists(filePath);

            String newFileName =  UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
            Path newPath = Paths.get(getImageDirectory(), fileName);
            imageFile.transferTo(new File(newPath.toFile().getAbsolutePath()));

            image.setType(imageFile.getContentType());
            image.setName(newFileName);
            image.setPath(newPath.toFile().getAbsolutePath());
            fileDataRepository.save(image);

            return FileValueMapper.convertToDto(image);
        } catch (Exception e) {
            throw new FileDataServiceException("Exception occurred while update image");
        }
    }

    @Override
    public void deleteImageById(Integer imageId) {
        try {
            FileData image = fileDataRepository.findById(imageId)
                    .orElseThrow(() -> new FileDataNotFoundException("Image not found with id " + imageId));
            String imagePath = image.getPath();
            String fileName = imagePath.substring(imagePath.lastIndexOf("/") + 1);
            Path filePath = Paths.get(getImageDirectory(), fileName);
            Files.deleteIfExists(filePath);

            fileDataRepository.delete(image);
        } catch (Exception e) {
            throw new FileDataServiceException("Exception occurred while delete image id " + imageId);
        }
    }

    @Override
    public FileResponse getImageById(Integer id) {
        try {
            FileData image = fileDataRepository.findById(id)
                    .orElseThrow(() -> new FileDataNotFoundException("Image not found with id " + id));
            return FileValueMapper.convertToDto(image);
        } catch (Exception e) {
            throw new FileDataServiceException("Exception occurred while fetch image id " + id + " from database");
        }
    }

    public String getImageDirectory() {
        String os = System.getProperty("os.name").toLowerCase();
        String directory;
        if (os.contains("win")) {
            directory = "src\\main\\resources\\static\\images";
        } else {
            directory = "src/main/resources/static/images";
        }
        return directory;
    }
}
