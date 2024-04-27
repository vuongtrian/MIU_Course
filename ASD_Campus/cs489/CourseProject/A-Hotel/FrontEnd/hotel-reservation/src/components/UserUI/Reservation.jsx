import { useEffect, useState } from "react";
import { Container, Form, FormGroup, FormLabel } from "react-bootstrap";

function Reservation() {
  const [loadedRoomDetails, setLoadedRoomDetails] = useState([]);
  const [selectedRoomDetailId, setSelectedRoomDetailId] = useState("");

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

  const handleRoomDetailChange = (event) => {
    setSelectedRoomDetailId(event.target.value);
  };


  return (
    <Container className="mt-3" style={{ width: "50%" }}>
      <h2>Reservation Form</h2>
      <Form.Group controlId="formRoomDetail">
        <Form.Label>Select an room type</Form.Label>
        <Form.Select
          value={selectedRoomDetailId}
          onChange={handleRoomDetailChange}
        >
          <option>Select room type</option>
          {loadedRoomDetails.map((roomDetail) => (
            <option key={roomDetail.id} value={roomDetail.id}>
              {roomDetail.type}
            </option>
          ))}
        </Form.Select>
      </Form.Group>
      {selectedRoomDetailId !== null && (
        loadedRoomDetails.filter(roomDetail => {
            return roomDetail.id === selectedRoomDetailId;
        })
      )}
    </Container>
  );
}

export default Reservation;
