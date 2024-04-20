package cs489.miu.edu.hotel_reservation_service.controller;

import cs489.miu.edu.hotel_reservation_service.entity.dto.APIResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailResponse;
import cs489.miu.edu.hotel_reservation_service.service.IRoomDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roomdetails")
public class RoomDetailController {
    public static final String SUCCESS = "Success";

    @Autowired
    private IRoomDetailService roomDetailService;

    @PostMapping
    public ResponseEntity<APIResponse> createRoomDetail(@RequestBody @Valid RoomDetailRequest roomDetailRequestDTO) {
        RoomDetailResponse roomDetailResponseDTO = roomDetailService.createRoomDetail(roomDetailRequestDTO);

        APIResponse<RoomDetailResponse> responseDTO = APIResponse
                .<RoomDetailResponse>builder()
                .status(SUCCESS)
                .results(roomDetailResponseDTO)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{roomDetailId}")
    public ResponseEntity<APIResponse> updateRoomDetail (@PathVariable int roomDetailId, @RequestBody @Valid RoomDetailRequest roomDetailRequestDTO) {
        RoomDetailResponse roomDetailResponseDTO = roomDetailService.updateRoomDetail(roomDetailId, roomDetailRequestDTO);
        APIResponse<RoomDetailResponse> responseDTO = APIResponse
                .<RoomDetailResponse>builder()
                .status(SUCCESS)
                .results(roomDetailResponseDTO)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllRoomDetail () {
        List<RoomDetailResponse> roomDetailResponseDTOList = roomDetailService.getAllRoomDetails();
        APIResponse<List<RoomDetailResponse>> responseDTO = APIResponse
                .<List<RoomDetailResponse>>builder()
                .status(SUCCESS)
                .results(roomDetailResponseDTOList)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{roomDetailId}")
    public ResponseEntity<APIResponse> getRoomDetail (@PathVariable int roomDetailId) {
        RoomDetailResponse roomDetailResponseDTO = roomDetailService.getRoomDetailById(roomDetailId);
        APIResponse<RoomDetailResponse> responseDTO = APIResponse
                .<RoomDetailResponse>builder()
                .status(SUCCESS)
                .results(roomDetailResponseDTO)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{roomDetailId}")
    public ResponseEntity<APIResponse> deleteRoomDetail (@PathVariable int roomDetailId) {
        roomDetailService.deleteRoomDetailById(roomDetailId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
