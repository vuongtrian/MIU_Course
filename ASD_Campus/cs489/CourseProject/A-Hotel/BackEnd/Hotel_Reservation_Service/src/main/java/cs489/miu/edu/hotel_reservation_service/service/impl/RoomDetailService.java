package cs489.miu.edu.hotel_reservation_service.service.impl;

import cs489.miu.edu.hotel_reservation_service.Util.ImageHandler;
import cs489.miu.edu.hotel_reservation_service.entity.FileData;
import cs489.miu.edu.hotel_reservation_service.entity.RoomDetail;
import cs489.miu.edu.hotel_reservation_service.entity.dto.FileDataRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.RoomDetailRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.RoomDetailResponseDTO;
import cs489.miu.edu.hotel_reservation_service.entity.mapper.FileDataValueMapper;
import cs489.miu.edu.hotel_reservation_service.entity.mapper.RoomDetailValueMapper;
import cs489.miu.edu.hotel_reservation_service.exception.FileDataNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.RoomDetailNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.RoomDetailServiceException;
import cs489.miu.edu.hotel_reservation_service.repository.IRoomDetailRepository;
import cs489.miu.edu.hotel_reservation_service.service.IRoomDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomDetailService implements IRoomDetailService {

    private IRoomDetailRepository roomDetailRepository;

    private ImageHandler imageHandler;


    @Override
    public RoomDetailResponseDTO createRoomDetail(RoomDetailRequestDTO roomDetailRequestDTO) {
        try {
            RoomDetail roomDetail = RoomDetailValueMapper.convertToEntity(roomDetailRequestDTO);
            if(roomDetailRequestDTO.getImages() != null && !roomDetailRequestDTO.getImages().isEmpty()) {
                List<MultipartFile> images = roomDetailRequestDTO.getImages();
                images.forEach(image -> {
                    FileDataRequestDTO imageRequestDTO = imageHandler.uploadImage(image);
                    FileData newImage = FileDataValueMapper.convertToEntity(imageRequestDTO);
                    roomDetail.getImages().add(newImage);
                });
            }
            RoomDetail roomDetailSaved = roomDetailRepository.save(roomDetail);
            return RoomDetailValueMapper.convertToDTO(roomDetailSaved);
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while create a new room detail");
        }
    }

    @Override
    public RoomDetailResponseDTO updateRoomDetail(Integer roomId, RoomDetailRequestDTO roomDetailRequestDTO) {
        try {
            RoomDetail roomDetail = roomDetailRepository.findById(roomId)
                    .orElseThrow(() -> new RoomDetailNotFoundException("Room detail not found with id " + roomId));
            roomDetail.setType(roomDetailRequestDTO.getType());
            roomDetail.setPrice(roomDetailRequestDTO.getPrice());
            roomDetail.setBedType(roomDetailRequestDTO.getBedType());
            roomDetail.setNumberOfBeds(roomDetailRequestDTO.getNumberOfBeds());
            roomDetail.setDescription(roomDetailRequestDTO.getDescription());
            return RoomDetailValueMapper.convertToDTO(roomDetailRepository.save(roomDetail));
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while update room detail id " + roomId);
        }
    }

    @Override
    public void deleteRoomDetail(Integer roomId) {
        try {
            RoomDetail roomDetail = roomDetailRepository.findById(roomId)
                    .orElseThrow(() -> new RoomDetailNotFoundException("Room detail not found with id " + roomId));
            roomDetail.getImages().forEach(image -> imageHandler.deleteImage(image.getPath()));
            roomDetailRepository.delete(roomDetail);
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while delete room detail id " + roomId);
        }
    }

    @Override
    public RoomDetailResponseDTO getRoomDetailById(Integer roomId) {
        try {
            RoomDetail roomDetail = roomDetailRepository.findById(roomId)
                    .orElseThrow(() -> new RoomDetailNotFoundException("Room detail not found with id " + roomId));
            return RoomDetailValueMapper.convertToDTO(roomDetail);
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while get room detail id " + roomId);
        }
    }

    @Override
    public List<RoomDetailResponseDTO> getAllRoomDetails() {
        try {
            return roomDetailRepository.findAll().stream().map(RoomDetailValueMapper::convertToDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while get all room detail");
        }
    }

    @Override
    public RoomDetailResponseDTO addImages(Integer roomId, List<MultipartFile> images) {
        try {
            RoomDetail roomDetail = roomDetailRepository.findById(roomId)
                    .orElseThrow(() -> new RoomDetailNotFoundException("Room detail not found with id " + roomId));
            images.forEach(image -> {
                FileDataRequestDTO imageRequestDTO = imageHandler.uploadImage(image);
                FileData newImage = FileDataValueMapper.convertToEntity(imageRequestDTO);
                roomDetail.getImages().add(newImage);
            });
            return RoomDetailValueMapper.convertToDTO(roomDetailRepository.save(roomDetail));
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while add image to room detail id " + roomId);
        }
    }

    @Override
    public RoomDetailResponseDTO updateImages(Integer roomId, Integer imageId, MultipartFile imageFile) {
        try {
            RoomDetail roomDetail = roomDetailRepository.findById(roomId)
                    .orElseThrow(() -> new RoomDetailNotFoundException("Room detail not found with id " + roomId));
            Optional<FileData> optionalCurImage = roomDetail.getImages().stream().filter(image -> image.getId().equals(imageId)).findFirst();
            if (optionalCurImage.isPresent()) {
                FileDataRequestDTO imageRequestDTO = imageHandler.uploadImage(imageFile);
                FileData newImage = FileDataValueMapper.convertToEntity(imageRequestDTO);
                FileData curImage = optionalCurImage.get();
                imageHandler.deleteImage(curImage.getPath());
                curImage.setPath(newImage.getPath());
                curImage.setName(newImage.getName());
                curImage.setType(newImage.getType());
            } else {
                throw new FileDataNotFoundException("Image not found with id " + imageId);
            }
            roomDetailRepository.save(roomDetail);
            return RoomDetailValueMapper.convertToDTO(roomDetail);
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while update image id "+ imageId +" to room detail id " + roomId);
        }
    }
}
