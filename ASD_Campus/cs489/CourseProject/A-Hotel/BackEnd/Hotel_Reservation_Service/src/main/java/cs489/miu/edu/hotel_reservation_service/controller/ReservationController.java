package cs489.miu.edu.hotel_reservation_service.controller;

import cs489.miu.edu.hotel_reservation_service.entity.dto.APIResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.reservation.ReservationRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.reservation.ReservationResponse;
import cs489.miu.edu.hotel_reservation_service.service.IReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    public static final String SUCCESS = "Success";

    @Autowired
    private IReservationService reservationService;

    @PostMapping
    public ResponseEntity<APIResponse> createReservation(@RequestBody @Valid ReservationRequest reservationRequest,
                                                         @RequestParam int roomNumber) {
        ReservationResponse reservationResponse = reservationService.createReservation(roomNumber, reservationRequest);
        APIResponse<ReservationResponse> responseDTO = APIResponse
                .<ReservationResponse>builder()
                .status(SUCCESS)
                .results(reservationResponse)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<APIResponse> updateReservation (@PathVariable int reservationId,
                                                          @RequestBody @Valid ReservationRequest reservationRequest,
                                                          @RequestParam int roomNumber) {
        ReservationResponse reservationResponse = reservationService.updateReservation(roomNumber, reservationId, reservationRequest);
        APIResponse<ReservationResponse> responseDTO = APIResponse
                .<ReservationResponse>builder()
                .status(SUCCESS)
                .results(reservationResponse)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllReservations () {
        List<ReservationResponse> reservations = reservationService.getAllReservations();
        APIResponse<List<ReservationResponse>> responseDTO = APIResponse
                .<List<ReservationResponse>>builder()
                .status(SUCCESS)
                .results(reservations)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<APIResponse> getReservation (@PathVariable int reservationId) {
        ReservationResponse reservationResponse = reservationService.getReservationById(reservationId);
        APIResponse<ReservationResponse> responseDTO = APIResponse
                .<ReservationResponse>builder()
                .status(SUCCESS)
                .results(reservationResponse)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<APIResponse> deleteReservation (@PathVariable int reservationId) {
        reservationService.deleteReservationById(reservationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
