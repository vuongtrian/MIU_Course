package cs489.miu.edu.hotel_reservation_service;

import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomResponse;
import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailResponse;
import cs489.miu.edu.hotel_reservation_service.service.IRoomService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class HotelReservationServiceApplicationTests {

	@Autowired
	private IRoomService roomService;

	@Test
	void contextLoads() {
	}

	@Test
	void getRoomByIdTest() {
		RoomResponse room = roomService.getRoomById(105);
		assertThat(
				new RoomDetailResponse(1,
						"Single Room",
						BigDecimal.valueOf(90.00),
						"Queen Bed",
						1,
						"A room with a single bed that is intended for one person to sleep in"));


	};
}
