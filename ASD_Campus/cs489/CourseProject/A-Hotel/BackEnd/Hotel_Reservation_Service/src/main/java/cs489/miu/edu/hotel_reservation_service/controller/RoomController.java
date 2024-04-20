package cs489.miu.edu.hotel_reservation_service.controller;

import cs489.miu.edu.hotel_reservation_service.entity.dto.APIResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomResponse;
import cs489.miu.edu.hotel_reservation_service.service.IRoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
    public static final String SUCCESS = "Success";

    @Autowired
    private IRoomService roomService;

    @PostMapping
    public ResponseEntity<APIResponse> createRoom (@RequestBody @Valid RoomRequest roomRequest) {
        RoomResponse roomResponse = roomService.createRoom(roomRequest);
        APIResponse<RoomResponse> responseDTO = APIResponse
                .<RoomResponse>builder()
                .status(SUCCESS)
                .results(roomResponse)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{roomNumber}")
    public ResponseEntity<APIResponse> updateRoom (@PathVariable int roomNumber, @RequestBody @Valid RoomRequest roomRequest) {
        RoomResponse roomResponse = roomService.updateRoom(roomNumber, roomRequest);
        APIResponse<RoomResponse> responseDTO = APIResponse
                .<RoomResponse>builder()
                .status(SUCCESS)
                .results(roomResponse)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllRooms() {
        List<RoomResponse> rooms = roomService.getAllRooms();
        APIResponse<List<RoomResponse>> responseDTO = APIResponse
                .<List<RoomResponse>>builder()
                .status(SUCCESS)
                .results(rooms)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{roomNumber}")
    public ResponseEntity<APIResponse> getRoom (@PathVariable int roomNumber) {
        RoomResponse roomResponse = roomService.getRoomById(roomNumber);
        APIResponse<RoomResponse> responseDTO = APIResponse
                .<RoomResponse>builder()
                .status(SUCCESS)
                .results(roomResponse)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{roomNumber}")
    public ResponseEntity<APIResponse> deleteRoom (@PathVariable int roomNumber) {
        roomService.deleteRoomById(roomNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
