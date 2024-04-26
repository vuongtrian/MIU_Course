package cs489.miu.edu.hotel_reservation_service.controller;

import cs489.miu.edu.hotel_reservation_service.entity.dto.APIResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileResponse;
import cs489.miu.edu.hotel_reservation_service.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {
    public static final String SUCCESS = "Success";

    @Autowired
    private IImageService imageService;

    @PostMapping
    public ResponseEntity<APIResponse> createImage(@RequestParam("roomDetailId") int roomDetailId,
                                                   @RequestParam("image") MultipartFile file) {
        FileResponse fileResponse = imageService.createImage(roomDetailId, file);
        APIResponse<FileResponse> response = APIResponse
                .<FileResponse>builder()
                .status(SUCCESS)
                .results(fileResponse)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{imageId}")
    public ResponseEntity<APIResponse> updateImage (@PathVariable int imageId,
                                                    @RequestParam("image") MultipartFile file) {
        FileResponse fileResponse = imageService.updateImage(imageId, file);
        APIResponse<FileResponse> response = APIResponse
                .<FileResponse>builder()
                .status(SUCCESS)
                .results(fileResponse)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<?> getImageById(@PathVariable int imageId) {
        byte[] imageResponse = imageService.getImageById(imageId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageResponse);
    }

    @GetMapping(value = "/roomDetails/{roomDetailId}")
    public ResponseEntity<?> getImageByRoomDetail(@PathVariable int roomDetailId) {
        byte[] imageResponse = imageService.getImageByRoomDetailId(roomDetailId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageResponse);
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<APIResponse> deleteImage(@PathVariable int imageId) {
        imageService.deleteImageById(imageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
