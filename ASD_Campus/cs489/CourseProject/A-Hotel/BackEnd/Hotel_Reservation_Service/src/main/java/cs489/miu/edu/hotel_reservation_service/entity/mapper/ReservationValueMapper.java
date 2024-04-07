package cs489.miu.edu.hotel_reservation_service.entity.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.Reservation;
import cs489.miu.edu.hotel_reservation_service.entity.dto.ReservationRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.ReservationResponseDTO;

public class ReservationValueMapper {
    public Reservation convertToEntity(ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = new Reservation();
        reservation.setStartDate(reservationRequestDTO.getStartDate());
        reservation.setEndDate(reservationRequestDTO.getEndDate());
        reservation.setTotalPrice(reservationRequestDTO.getTotalPrice());
        reservation.setNumberOfGuest(reservationRequestDTO.getNumberOfGuest());
        reservation.setRoom(reservationRequestDTO.getRoom());
        reservation.setCustomer(reservationRequestDTO.getCustomer());
        return reservation;
    }

    public ReservationResponseDTO convertToDTO(Reservation reservation) {
        ReservationResponseDTO reservationResponseDTO = new ReservationResponseDTO();
        reservationResponseDTO.setReservationNumber(reservation.getReservationNumber());
        reservationResponseDTO.setStartDate(reservation.getStartDate());
        reservationResponseDTO.setEndDate(reservation.getEndDate());
        reservationResponseDTO.setTotalPrice(reservation.getTotalPrice());
        reservationResponseDTO.setNumberOfGuest(reservation.getNumberOfGuest());
        reservationResponseDTO.setRoom(reservation.getRoom());
        reservationResponseDTO.setCustomer(reservation.getCustomer());
        return reservationResponseDTO;
    }

    public static String jsonAsString(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
