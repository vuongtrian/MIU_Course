import { useState } from "react";
import { Container } from "react-bootstrap";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useNavigate } from "react-router-dom";

function RoomDetailForm() {
  const [roomDetailData, setRoomDetailData] = useState({
    type: "",
    price: 0,
    bedType: "",
    numberOfBeds: 0,
    description: "",
  });

  const [selectedFile, setSelectedFile] = useState(null);

  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setRoomDetailData({ ...roomDetailData, [name]: value });
  };

  const handleImage = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch("http://localhost:8080/api/v1/roomdetails", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(roomDetailData),
      });

      if (!response.ok) {
        throw new Error("Failed to submit form");
      }

      setRoomDetailData({
        type: "",
        price: 0,
        bedType: "",
        numberOfBeds: 0,
        description: "",
      });

      navigate("/management/roomDetails")
    } catch (error) {
      console.error("Error submitting form:", error);
      // Handle error (e.g., display an error message to the user)
    }
  };

  return (
    <Container className="mt-3" style={{ width: "50%" }}>
      <h2 className="mb-3">Room Detail Form</h2>
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="formType">
          <Form.Label>Type</Form.Label>
          <Form.Control
            type="text"
            name="type"
            value={roomDetailData.type}
            onChange={handleChange}
          />
        </Form.Group>
        <Form.Group controlId="formPrice">
          <Form.Label>Price</Form.Label>
          <Form.Control
            type="number"
            name="price"
            value={roomDetailData.price}
            onChange={handleChange}
            min={0}
          />
        </Form.Group>
        <Form.Group controlId="formBedType">
          <Form.Label>Bed Type</Form.Label>
          <Form.Control
            type="text"
            name="bedType"
            value={roomDetailData.bedType}
            onChange={handleChange}
          />
        </Form.Group>
        <Form.Group controlId="formNumberOfBeds">
          <Form.Label>Number Of Beds</Form.Label>
          <Form.Control
            type="number"
            name="numberOfBeds"
            value={roomDetailData.numberOfBeds}
            onChange={handleChange}
            min={0}
          />
        </Form.Group>
        <Form.Group controlId="formDescription" className="mb-3">
          <Form.Label>Description</Form.Label>
          <Form.Control
            as="textarea"
            rows={3}
            name="description"
            value={roomDetailData.description}
            onChange={handleChange}
          />
        </Form.Group>
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </Container>
  );
}

export default RoomDetailForm;
