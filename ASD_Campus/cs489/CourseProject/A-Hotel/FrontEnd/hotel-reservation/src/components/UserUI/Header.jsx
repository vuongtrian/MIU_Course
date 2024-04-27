import logoImg from "../../assets/logo.jpeg";
import {
  Container,
  Image,
  Nav,
  Navbar,
  NavDropdown,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
function Header() {
  return (
    <Navbar collapseOnSelect expand="lg" className="bg-body-tertiary">
      <Container>
        
          <Navbar.Brand href="/">
            <Image
              alt="A-Hotel logo"
              src={logoImg}
              width="120"
              height="120"
              roundedCircle
              className="d-inline-block align-center"
            />{" "}
            A-Hotel
          </Navbar.Brand>
        
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#about">About</Nav.Link>
            <Nav.Link href="#room">Room</Nav.Link>
            <NavDropdown title="Management" id="collapsible-nav-dropdown">
              <NavDropdown.Item as={Link} to="/management/roomDetails">
                Room Details
              </NavDropdown.Item>
              <NavDropdown.Item href="#room">Rooms</NavDropdown.Item>
              {/* <NavDropdown.Divider /> */}
              <NavDropdown.Item href="#user">User</NavDropdown.Item>
            </NavDropdown>
          </Nav>

          <Nav className="gap-2">
            <Link to={"user/reservation"}>
              <Button>Book Now!</Button>
            </Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Header;
