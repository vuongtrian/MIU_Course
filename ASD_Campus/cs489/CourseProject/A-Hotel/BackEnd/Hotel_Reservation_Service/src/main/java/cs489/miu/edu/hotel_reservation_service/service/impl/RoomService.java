package cs489.miu.edu.hotel_reservation_service.service.impl;

import cs489.miu.edu.hotel_reservation_service.entity.Room;
import cs489.miu.edu.hotel_reservation_service.entity.dto.reservation.ReservationValueMapper;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomValueMapper;
import cs489.miu.edu.hotel_reservation_service.exception.RoomNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.RoomServiceException;
import cs489.miu.edu.hotel_reservation_service.repository.IRoomRepository;
import cs489.miu.edu.hotel_reservation_service.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private IRoomRepository roomRepository;


    @Override
    public RoomResponse createRoom(RoomRequest roomRequest) {
        try {
            Room room = RoomValueMapper.convertToEntity(roomRequest);
            return RoomValueMapper.convertToDto(roomRepository.save(room));
        } catch (Exception e) {
            throw new RoomServiceException("Exception occurred while create a new room");
        }
    }

    @Override
    public RoomResponse updateRoom(Integer roomId, RoomRequest roomRequest) {
        try {
            Room room = roomRepository.findById(roomId)
                    .orElseThrow(() -> new RoomNotFoundException("Room not found with id " + roomId));
            room.setReservations(roomRequest.reservations().stream().map(ReservationValueMapper::convertToEntity).toList());
            return RoomValueMapper.convertToDto(roomRepository.save(room));
        } catch (Exception e) {
            throw new RoomServiceException("Exception occurred while update a room");
        }
    }

    @Override
    public void deleteRoomById(Integer roomId) {
        try {
            Room room = roomRepository.findById(roomId)
                    .orElseThrow(() -> new RoomNotFoundException("Room not found with id " + roomId));
            roomRepository.delete(room);
        } catch (Exception e) {
            throw new RoomServiceException("Exception occurred while delete a room");
        }
    }

    @Override
    public RoomResponse getRoomById(Integer roomId) {
        try {
            Room room = roomRepository.findById(roomId)
                    .orElseThrow(() -> new RoomNotFoundException("Room not found with id " + roomId));
            return RoomValueMapper.convertToDto(room);
        } catch (Exception e) {
            throw new RoomServiceException("Exception occurred while get room number " + roomId);
        }
    }

    @Override
    public List<RoomResponse> getAllRooms() {
        try {
            return roomRepository.findAll().stream().map(RoomValueMapper::convertToDto).toList();
        } catch (Exception e) {
            throw new RoomServiceException("Exception occurred while get all room");
        }
    }
}
