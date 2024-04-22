package cs489.miu.edu.hotel_reservation_service.service.impl;

import cs489.miu.edu.hotel_reservation_service.entity.Reservation;
import cs489.miu.edu.hotel_reservation_service.entity.Room;
import cs489.miu.edu.hotel_reservation_service.entity.RoomDetail;
import cs489.miu.edu.hotel_reservation_service.entity.dto.reservation.ReservationRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.reservation.ReservationResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.reservation.ReservationValueMapper;
import cs489.miu.edu.hotel_reservation_service.exception.ReservationNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.ReservationServiceException;
import cs489.miu.edu.hotel_reservation_service.exception.RoomDetailNotFoundException;
import cs489.miu.edu.hotel_reservation_service.exception.RoomNotFoundException;
import cs489.miu.edu.hotel_reservation_service.repository.IReservationRepository;
import cs489.miu.edu.hotel_reservation_service.repository.IRoomRepository;
import cs489.miu.edu.hotel_reservation_service.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    private IReservationRepository reservationRepository;

    @Autowired
    private IRoomRepository roomRepository;

    @Override
    public ReservationResponse createReservation(Integer roomNumber, ReservationRequest reservationRequest) {
        try {
            Room room = roomRepository.findById(roomNumber)
                    .orElseThrow(() -> new RoomNotFoundException("Room not found with id " + roomNumber));
            Reservation reservation = ReservationValueMapper.convertToEntity(reservationRequest);
            reservation.setRoom(room);
            return ReservationValueMapper.convertToDto(reservationRepository.save(reservation));
        } catch (Exception e) {
            throw new ReservationServiceException("Exception occurred while create a new reservation");
        }
    }

    @Override
    public ReservationResponse updateReservation(Integer roomNumber, Integer reservationId, ReservationRequest reservationRequest) {
        try {
            Reservation reservation = reservationRepository.findById(reservationId)
                    .orElseThrow(() -> new ReservationNotFoundException("Reservation not found with id " + reservationId));
            reservation.setStartDate(reservationRequest.startDate());
            reservation.setEndDate(reservationRequest.endDate());
            reservation.setTotalPrice(reservationRequest.totalPrice());
            reservation.setNumberOfGuest(reservationRequest.numberOfGuest());
            if(!reservation.getRoom().getRoomNumber().equals(roomNumber) ) {
                Room room = roomRepository.findById(roomNumber)
                        .orElseThrow(() -> new RoomNotFoundException("Room not found with id " + roomNumber));
                reservation.setRoom(room);
            }
            return ReservationValueMapper.convertToDto(reservationRepository.save(reservation));
        } catch (Exception e) {
            throw new ReservationServiceException("Exception occurred while update a reservation");
        }
    }

    @Override
    public void deleteReservationById(Integer reservationId) {
        try {
            Reservation reservation = reservationRepository.findById(reservationId)
                    .orElseThrow(() -> new ReservationNotFoundException("Reservation not found with id " + reservationId));
            reservationRepository.delete(reservation);
        } catch (Exception e) {
            throw new ReservationServiceException("Exception occurred while delete a reservation");
        }
    }

    @Override
    public ReservationResponse getReservationById(Integer reservationId) {
        try {
            Reservation reservation = reservationRepository.findById(reservationId)
                    .orElseThrow(() -> new ReservationNotFoundException("Reservation not found with id " + reservationId));
            return ReservationValueMapper.convertToDto(reservation);
        } catch (Exception e) {
            throw new ReservationServiceException("Exception occurred while get reservation id " + reservationId);
        }
    }

    @Override
    public List<ReservationResponse> getAllReservations() {
        try {
            return reservationRepository.findAll().stream().map(ReservationValueMapper::convertToDto).toList();
        } catch (Exception e) {
            throw new ReservationServiceException("Exception occurred while get all reservation");
        }
    }
}
