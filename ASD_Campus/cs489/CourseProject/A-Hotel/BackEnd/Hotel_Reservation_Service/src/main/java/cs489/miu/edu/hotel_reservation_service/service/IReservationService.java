package cs489.miu.edu.hotel_reservation_service.service;

import cs489.miu.edu.hotel_reservation_service.entity.dto.reservation.ReservationRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.reservation.ReservationResponse;

import java.util.List;

public interface IReservationService {
    ReservationResponse createReservation(Integer roomNumber ,ReservationRequest reservationRequest);
    ReservationResponse updateReservation(Integer roomNumber, Integer reservationId, ReservationRequest reservationRequest);
    void deleteReservationById(Integer reservationId);
    ReservationResponse getReservationById(Integer reservationId);
    List<ReservationResponse> getAllReservations();
}
