import { useEffect, useState } from "react";
import RoomDetailItem from "./RoomDetailItem";
import { Container, Row } from "react-bootstrap";

function RoomDetails() {
  const [loadedRoomDetails, setLoadedRoomDetails] = useState([]);

  useEffect(() => {
    async function fetchRoomDetails() {
      try {
        const response = await fetch(
          "http://localhost:8080/api/v1/roomdetails",
          {
            method: "GET",
          }
        );

        if (!response.ok) {
          throw new Error("Failed to fetch rooms");
        }

        const roomsData = await response.json();
        const rooms = roomsData.results;
        setLoadedRoomDetails(rooms);
      } catch (error) {
        console.error("Error fetching rooms:", error);
      }
    }

    fetchRoomDetails(); // Invoke the fetchRooms function
  }, []);

  return (
    <Container id="roomDetails" className="mt-3">
      <Row xs={1} md={2}>
      {loadedRoomDetails.map((roomDetail) => (
        <RoomDetailItem key={roomDetail.id} roomDetail={roomDetail}/>
      ))}
      </Row>
    </Container>
  );
}

export default RoomDetails;
