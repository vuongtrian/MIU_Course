package cs489.miu.edu.hotel_reservation_service.controller;

import cs489.miu.edu.hotel_reservation_service.entity.dto.APIResponse;
import cs489.miu.edu.hotel_reservation_service.service.IRoomDetailService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roomdetails")
public class RoomDetailController {
    public static final String SUCCESS = "Success";

    private IRoomDetailService roomDetailService;
/*
    @PostMapping
    public ResponseEntity<APIResponse> createRoomDetail(@RequestBody @Valid RoomDetailRequestDTO roomDetailRequestDTO) {
        RoomDetailResponseDTO roomDetailResponseDTO = roomDetailService.createRoomDetail(roomDetailRequestDTO);

        APIResponse<RoomDetailResponseDTO> responseDTO = APIResponse
                .<RoomDetailResponseDTO>builder()
                .status(SUCCESS)
                .results(roomDetailResponseDTO)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{roomDetailId}")
    public ResponseEntity<APIResponse> updateRoomDetail (@PathVariable int roomDetailId, @RequestBody @Valid RoomDetailRequestDTO roomDetailRequestDTO) {
        RoomDetailResponseDTO roomDetailResponseDTO = roomDetailService.updateRoomDetail(roomDetailId, roomDetailRequestDTO);
        APIResponse<RoomDetailResponseDTO> responseDTO = APIResponse
                .<RoomDetailResponseDTO>builder()
                .status(SUCCESS)
                .results(roomDetailResponseDTO)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllRoomDetail () {
        List<RoomDetailResponseDTO> roomDetailResponseDTOList = roomDetailService.getAllRoomDetails();
        APIResponse<List<RoomDetailResponseDTO>> responseDTO = APIResponse
                .<List<RoomDetailResponseDTO>>builder()
                .status(SUCCESS)
                .results(roomDetailResponseDTOList)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{roomDetailId}")
    public ResponseEntity<APIResponse> getRoomDetail (@PathVariable int roomDetailId) {
        RoomDetailResponseDTO roomDetailResponseDTO = roomDetailService.getRoomDetailById(roomDetailId);
        APIResponse<RoomDetailResponseDTO> responseDTO = APIResponse
                .<RoomDetailResponseDTO>builder()
                .status(SUCCESS)
                .results(roomDetailResponseDTO)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{roomDetailId}")
    public ResponseEntity<APIResponse> deleteRoomDetail (@PathVariable int roomDetailId) {
        roomDetailService.deleteRoomDetail(roomDetailId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

 */
}
