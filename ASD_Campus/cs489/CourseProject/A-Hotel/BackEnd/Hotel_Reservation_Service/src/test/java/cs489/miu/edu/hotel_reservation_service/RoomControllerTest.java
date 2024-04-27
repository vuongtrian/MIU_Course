package cs489.miu.edu.hotel_reservation_service;

import cs489.miu.edu.hotel_reservation_service.controller.RoomController;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailResponse;
import cs489.miu.edu.hotel_reservation_service.service.impl.RoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RoomController.class)
public class RoomControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomService roomService;

    @Test
    public void testGetRoom() throws Exception {
        // Mock response from RoomService
        int roomNumber = 105;
        RoomResponse roomResponse = new RoomResponse(
                roomNumber,
                new RoomDetailResponse(
                        1,
                        "Single Room",
                        BigDecimal.valueOf(90.00),
                        "Queen Bed",
                        1,
                        "A room with a single bed that is intended for one person to sleep in"
                )
        );
        when(roomService.getRoomById(roomNumber)).thenReturn(roomResponse);

        // Perform GET request
        mockMvc.perform(get("/api/v1/rooms/{roomNumber}", roomNumber))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("Success"))
                .andExpect(jsonPath("$.results.roomNumber").value(roomNumber))
                .andExpect(jsonPath("$.results.roomDetailResponse.id").value(1))
                .andExpect(jsonPath("$.results.roomDetailResponse.type").value("Single Room"))
                .andExpect(jsonPath("$.results.roomDetailResponse.price").value(90.00))
                .andExpect(jsonPath("$.results.roomDetailResponse.bedType").value("Queen Bed"))
                .andExpect(jsonPath("$.results.roomDetailResponse.numberOfBeds").value(1))
                .andExpect(jsonPath("$.results.roomDetailResponse.description").value("A room with a single bed that is intended for one person to sleep in"));

        // Verify that RoomService method was called
        verify(roomService, times(1)).getRoomById(roomNumber);
    }
}
