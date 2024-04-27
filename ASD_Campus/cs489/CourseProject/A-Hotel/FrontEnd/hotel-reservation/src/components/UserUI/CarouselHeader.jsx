import Carousel from "react-bootstrap/Carousel";
import Image from "react-bootstrap/Image";
import sliderImg from "../../assets/slider_3.jpeg";
import { Container } from "react-bootstrap";

function CarouselHeader() {
  return (
    <Container>
      <Carousel>
        <Carousel.Item>
          <Image src={sliderImg} alt="A-Hotel Slider 2" style={{width: '100%'}} />
          <Carousel.Caption>
            <h3>Welcome to A-Hotel</h3>
            <p>Make your experience relaxing and memorable</p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>
    </Container>
  );
}

export default CarouselHeader;
