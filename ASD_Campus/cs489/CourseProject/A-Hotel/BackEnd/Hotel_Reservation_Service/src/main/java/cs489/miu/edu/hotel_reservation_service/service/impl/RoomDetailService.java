package cs489.miu.edu.hotel_reservation_service.service.impl;

import cs489.miu.edu.hotel_reservation_service.entity.FileData;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.file.FileValueMapper;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomValueMapper;
import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailValueMapper;
import cs489.miu.edu.hotel_reservation_service.entity.RoomDetail;
import cs489.miu.edu.hotel_reservation_service.exception.RoomDetailNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.RoomDetailServiceException;
import cs489.miu.edu.hotel_reservation_service.repository.IRoomDetailRepository;
import cs489.miu.edu.hotel_reservation_service.service.IRoomDetailService;
import cs489.miu.edu.hotel_reservation_service.service.IRoomService;
import cs489.miu.edu.hotel_reservation_service.util.ImageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;

@Service
public class RoomDetailService implements IRoomDetailService {

    @Autowired
    private IRoomDetailRepository roomDetailRepository;

    @Autowired
    private IRoomService roomService;

    @Override
    public RoomDetailResponse createRoomDetail(RoomDetailRequest roomDetailRequest) {
        try {
            RoomDetailRequest updatedRoomDetailRequest = new RoomDetailRequest(
                    roomDetailRequest.type(),
                    roomDetailRequest.price(),
                    roomDetailRequest.bedType(),
                    roomDetailRequest.numberOfBeds(),
                    roomDetailRequest.description()
//                    roomDetailRequest.rooms(),
//                    images == null  ? new ArrayList<>()
//                            : images.stream().map(ImageHandler::uploadImage).toList()
            );

            RoomDetail roomDetail = RoomDetailValueMapper.convertToEntity(updatedRoomDetailRequest);
            return RoomDetailValueMapper.convertToDto(roomDetailRepository.save(roomDetail));
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while create a new room detail");
        }
    }

    @Override
    public RoomDetailResponse updateRoomDetail(Integer roomDetailId, RoomDetailRequest roomDetailRequest) {
        try {
            RoomDetail roomDetail = roomDetailRepository.findById(roomDetailId)
                    .orElseThrow(() -> new RoomDetailNotFoundException("Room detail not found with id " + roomDetailId));
            roomDetail.setType(roomDetailRequest.type());
            roomDetail.setPrice(roomDetailRequest.price());
            roomDetail.setBedType(roomDetailRequest.bedType());
            roomDetail.setNumberOfBeds(roomDetailRequest.numberOfBeds());
            roomDetail.setDescription(roomDetailRequest.description());
//            roomDetail.setRooms(roomDetailRequest.rooms().stream().map(RoomValueMapper::convertToEntity).toList());
//
//            if(images != null) {
//                roomDetail.getImages().forEach(image -> ImageHandler.deleteImage(image.getPath()));
//                List<FileRequest> fileRequests = images.stream().map(ImageHandler::uploadImage).toList();
//                roomDetail.setImages(fileRequests.stream().map(FileValueMapper::convertToEntity).toList());
//            }
            RoomDetail updatedRoomDetail = roomDetailRepository.save(roomDetail);
            return RoomDetailValueMapper.convertToDto(roomDetailRepository.save(updatedRoomDetail));
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while update room detail id " + roomDetailId);
        }
    }

    @Override
    public void deleteRoomDetailById(Integer roomDetailId) {
        try {
            RoomDetail roomDetail = roomDetailRepository.findById(roomDetailId)
                    .orElseThrow(() -> new RoomDetailNotFoundException("Room detail not found with id " + roomDetailId));
//            roomDetail.getImages().forEach(image -> ImageHandler.deleteImage(image.getPath()));
            roomDetailRepository.delete(roomDetail);
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while delete room detail id " + roomDetailId);
        }
    }

    @Override
    public RoomDetailResponse getRoomDetailById(Integer roomDetailId) {
        try {
            RoomDetail roomDetail = roomDetailRepository.findById(roomDetailId)
                    .orElseThrow(() -> new RoomDetailNotFoundException("Room detail not found with id " + roomDetailId));
            return RoomDetailValueMapper.convertToDto(roomDetail);
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while get room detail id " + roomDetailId);
        }
    }

    @Override
    public List<RoomDetailResponse> getAllRoomDetails() {
        try {
            return roomDetailRepository.findAll().stream().map(RoomDetailValueMapper::convertToDto).toList();
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while get all room detail");
        }
    }


}
