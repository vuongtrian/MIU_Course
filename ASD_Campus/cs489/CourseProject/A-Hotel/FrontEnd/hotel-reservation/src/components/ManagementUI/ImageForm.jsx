import { useState } from "react";
import { Container } from "react-bootstrap";
import { useLocation } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useNavigate } from "react-router-dom";
function ImageForm() {
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const roomDetailId = queryParams.get("roomDetailId");

  const [selectedFile, setSelectedFile] = useState(null);

  const navigate = useNavigate();

  const handleFileChange = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const formData = new FormData();
      formData.append("roomDetailId", roomDetailId);
      formData.append("image", selectedFile);

      const response = await fetch("http://localhost:8080/api/v1/images", {
        method: "POST",
        body: formData,
      });
      if (!response.ok) {
        throw new Error("Failed to upload image");
      }
      console.log("Image uploaded successfully");

      setSelectedFile(null);
      navigate("/management/roomDetails")
    } catch (error) {
      console.error("Error uploading image:", error);
      // Handle error (e.g., display an error message to the user)
    }
  };

  return (
    <Container>
      <h2>Upload Image For Room Detail {roomDetailId}</h2>
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="formImage">
          <Form.Label>Choose Image</Form.Label>
          <Form.Control type="file" onChange={handleFileChange} />
        </Form.Group>
        <Button variant="primary" type="submit">
          Upload
        </Button>
      </Form>
    </Container>
  );
}

export default ImageForm;
