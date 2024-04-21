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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roomdetails")
public class RoomDetailController {
    public static final String SUCCESS = "Success";

    @Autowired
    private IRoomDetailService roomDetailService;

    @PostMapping
    public ResponseEntity<APIResponse> createRoomDetail(@RequestBody @Valid RoomDetailRequest roomDetailRequest) {
                                                        //@RequestPart(name = "images", required = false) List<MultipartFile> images) {
//        RoomDetailResponse roomDetailResponse = roomDetailService.createRoomDetail(roomDetailRequest, images);
        RoomDetailResponse roomDetailResponse = roomDetailService.createRoomDetail(roomDetailRequest);
        APIResponse<RoomDetailResponse> responseDTO = APIResponse
                .<RoomDetailResponse>builder()
                .status(SUCCESS)
                .results(roomDetailResponse)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{roomDetailId}")
//    public ResponseEntity<APIResponse> updateRoomDetail (@PathVariable int roomDetailId,
//                                                         @RequestPart @Valid RoomDetailRequest roomDetailRequest,
//                                                         @RequestPart List<MultipartFile> images) {
    public ResponseEntity<APIResponse> updateRoomDetail (@PathVariable int roomDetailId,
                                                         @RequestBody @Valid RoomDetailRequest roomDetailRequest) {
        RoomDetailResponse roomDetailResponse = roomDetailService.updateRoomDetail(roomDetailId, roomDetailRequest);
        APIResponse<RoomDetailResponse> response = APIResponse
                .<RoomDetailResponse>builder()
                .status(SUCCESS)
                .results(roomDetailResponse)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllRoomDetail () {
        List<RoomDetailResponse> roomDetailResponseList = roomDetailService.getAllRoomDetails();
        APIResponse<List<RoomDetailResponse>> response = APIResponse
                .<List<RoomDetailResponse>>builder()
                .status(SUCCESS)
                .results(roomDetailResponseList)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{roomDetailId}")
    public ResponseEntity<APIResponse> getRoomDetail (@PathVariable int roomDetailId) {
        RoomDetailResponse roomDetailResponse = roomDetailService.getRoomDetailById(roomDetailId);
        APIResponse<RoomDetailResponse> response = APIResponse
                .<RoomDetailResponse>builder()
                .status(SUCCESS)
                .results(roomDetailResponse)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{roomDetailId}")
    public ResponseEntity<APIResponse> deleteRoomDetail (@PathVariable int roomDetailId) {
        roomDetailService.deleteRoomDetailById(roomDetailId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
