package cs489.miu.edu.hotel_reservation_service.service.impl;

import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomValueMapper;
import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailValueMapper;
import cs489.miu.edu.hotel_reservation_service.entity.RoomDetail;
import cs489.miu.edu.hotel_reservation_service.exception.RoomDetailNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.RoomDetailServiceException;
import cs489.miu.edu.hotel_reservation_service.repository.IRoomDetailRepository;
import cs489.miu.edu.hotel_reservation_service.service.IRoomDetailService;
import cs489.miu.edu.hotel_reservation_service.util.ImageHandler;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RoomDetailService implements IRoomDetailService {

    private IRoomDetailRepository roomDetailRepository;

    @Override
    public RoomDetailResponse createRoomDetail(RoomDetailRequest roomDetailRequest) {
        try {
            RoomDetail roomDetail = RoomDetailValueMapper.convertToEntity(roomDetailRequest);
            return RoomDetailValueMapper.convertToDto(roomDetailRepository.save(roomDetail));
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while create a new room detail");
        }
    }

    @Override
    public RoomDetailResponse updateRoomDetail(Integer roomId, RoomDetailRequest roomDetailRequest) {
        try {
            RoomDetail roomDetail = roomDetailRepository.findById(roomId)
                    .orElseThrow(() -> new RoomDetailNotFoundException("Room detail not found with id " + roomId));
            roomDetail.setType(roomDetailRequest.type());
            roomDetail.setPrice(roomDetailRequest.price());
            roomDetail.setBedType(roomDetailRequest.bedType());
            roomDetail.setNumberOfBeds(roomDetailRequest.numberOfBeds());
            roomDetail.setDescription(roomDetailRequest.description());
            roomDetail.setRooms(roomDetailRequest.rooms().stream().map(RoomValueMapper::convertToEntity).toList());
            return RoomDetailValueMapper.convertToDto(roomDetailRepository.save(roomDetail));
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while update room detail id " + roomId);
        }
    }

    @Override
    public void deleteRoomDetailById(Integer roomId) {
        try {
            RoomDetail roomDetail = roomDetailRepository.findById(roomId)
                    .orElseThrow(() -> new RoomDetailNotFoundException("Room detail not found with id " + roomId));
            roomDetail.getImages().forEach(image -> ImageHandler.deleteImage(image.getPath()));
            roomDetailRepository.delete(roomDetail);
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while delete room detail id " + roomId);
        }
    }

    @Override
    public RoomDetailResponse getRoomDetailById(Integer roomId) {
        try {
            RoomDetail roomDetail = roomDetailRepository.findById(roomId)
                    .orElseThrow(() -> new RoomDetailNotFoundException("Room detail not found with id " + roomId));
            return RoomDetailValueMapper.convertToDto(roomDetail);
        } catch (Exception e) {
            throw new RoomDetailServiceException("Exception occurred while get room detail id " + roomId);
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
