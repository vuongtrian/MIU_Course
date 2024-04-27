import { useState } from "react";
import { Container } from "react-bootstrap";
import { useLocation } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useNavigate } from "react-router-dom";

function RoomForm() {
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const roomDetailId = queryParams.get("roomDetailId");

  const [formData, setFormData] = useState({
    roomDetailId: roomDetailId || "",
    roomNumber: "",
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch(
        `http://localhost:8080/api/v1/rooms?roomDetailId=${formData.roomDetailId}&roomNumber=${formData.roomNumber}`,
        {
          method: "POST",
        }
      );

      if (!response.ok) {
        throw new Error("Failed to submit form");
      }

      console.log("Form submitted successfully");
      // Optionally, you can redirect or perform other actions after successful form submission
      setFormData({
        roomDetailId: "",
        roomNumber: ""
      })
      navigate("/management/roomDetails")
    } catch (error) {
      console.error("Error submitting form:", error);
      // Handle error (e.g., display an error message to the user)
    }
  };

  return (
    <Container className="mt-3" style={{ width: "50%" }}>
      <h2 className="mb-3">Add Room For Room Detail {roomDetailId}</h2>
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="formRoomNumber" className="mb-3">
          <Form.Label>Room Number</Form.Label>
          <Form.Control
            type="text"
            name="roomNumber"
            value={formData.roomNumber}
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

export default RoomForm;
