import { useEffect, useState } from "react";
import Card from "react-bootstrap/Card";
import ListGroup from "react-bootstrap/ListGroup";

function RoomDetailItem({ roomDetail }) {
  const [loadedImage, setLoadedImage] = useState();
  useEffect(() => {
    async function fetchImagesByRoomDetailId() {
      try {
        const response = await fetch(
          `http://localhost:8080/api/v1/images/roomDetails/${roomDetail.id}`
        );

        if (!response.ok) {
          throw new Error('Failed to fetch images');
        }

        const imageData = await response.blob();
        const imageUrl = URL.createObjectURL(imageData);
        setLoadedImage(imageUrl);
      } catch (error) {
        console.error('Error fetching images:', error);
      }
    }

    fetchImagesByRoomDetailId();
  }, [roomDetail.id]);

  return (
    <Card style={{ width: "18rem", margin: "10px" }}>
      <Card.Img variant="top" src={loadedImage} />
      <Card.Body>
        <Card.Title>{roomDetail.type}</Card.Title>
        <Card.Text>{roomDetail.description}</Card.Text>
      </Card.Body>
      <ListGroup className="list-group-flush">
        <ListGroup.Item>Price: ${roomDetail.price}</ListGroup.Item>
        <ListGroup.Item>Bed Type: {roomDetail.bedType}</ListGroup.Item>
        <ListGroup.Item>
          Number Of Beds: {roomDetail.numberOfBeds}
        </ListGroup.Item>
      </ListGroup>
      <Card.Body>
        <Card.Link href="#">Available rooms?</Card.Link>
        <Card.Link href="#">Book now!</Card.Link>
      </Card.Body>
    </Card>
  );
}

export default RoomDetailItem;