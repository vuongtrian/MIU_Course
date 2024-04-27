import { useState, useEffect } from "react";
import { Button, Container } from "react-bootstrap";
import Table from "react-bootstrap/Table";
import { Link } from 'react-router-dom';

function RoomDetailManagement() {
  const [loadedRoomDetails, setLoadedRoomDetails] = useState([]);
  const [loadedRooms, setLoadedRooms] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        const [roomDetailsResponse, roomsResponse] = await Promise.all([
          fetch("http://localhost:8080/api/v1/roomdetails"),
          fetch("http://localhost:8080/api/v1/rooms"),
        ]);

        if (!roomDetailsResponse.ok) {
          throw new Error("Failed to fetch room details");
        }

        if (!roomsResponse.ok) {
          throw new Error("Failed to fetch rooms");
        }

        const [roomDetailsData, roomsData] = await Promise.all([
          roomDetailsResponse.json(),
          roomsResponse.json(),
        ]);

        setLoadedRoomDetails(roomDetailsData.results);
        setLoadedRooms(roomsData.results);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    }

    fetchData();
  }, []);

  return (
    <Container className="mt-3">
      <h2 className="mb-3">Room Management</h2>
      <Table striped bordered hover responsive>
        <thead>
          <tr>
            <th style={{ width: "5%" }}>Id</th>
            <th style={{ width: "10%" }}>Type</th>
            <th style={{ width: "10%" }}>Bed Type</th>
            <th style={{ width: "10%" }}>Number Of Beds</th>
            <th style={{ width: "5%" }}>Price</th>
            <th style={{ width: "20%" }}>Description</th>
            <th style={{ width: "20%" }}>Rooms</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {loadedRoomDetails.map((roomDetail) => (
            <tr key={roomDetail.id}>
              <td>{roomDetail.id}</td>
              <td>{roomDetail.type}</td>
              <td>{roomDetail.bedType}</td>
              <td>{roomDetail.numberOfBeds}</td>
              <td>{roomDetail.price}</td>
              <td>{roomDetail.description}</td>
              <td>
                {loadedRooms
                  .filter(
                    (room) => room.roomDetailResponse.id === roomDetail.id
                  )
                  .map((room) => room.roomNumber)
                  .join(", ")}
              </td>
              <td>
                <Link to={`addRooms?roomDetailId=${roomDetail.id}`}>
                  <Button variant="primary">Add room</Button>
                </Link>
                <Link to={`addImage?roomDetailId=${roomDetail.id}`}>
                  <Button variant="primary">Add Image</Button>
                </Link>
                <Button variant="secondary">Edit</Button>
                <Button variant="danger">Delete</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
      <Link to={"addRoomDetails"}>
        <Button>Add</Button>
      </Link>
    </Container>
  );
}

export default RoomDetailManagement;
