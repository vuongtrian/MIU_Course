// import logo from './logo.svg';
import "./App.css";
import Header from "./components/UserUI/Header";
import Home from "./components/UserUI/Home";
import ImageForm from "./components/ManagementUI/ImageForm";
import RoomDetailForm from "./components/ManagementUI/RoomDetailForm";
import RoomDetailManagement from "./components/ManagementUI/RoomDetailManagement"
import RoomForm from "./components/ManagementUI/RoomForm"
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Reservation from "./components/UserUI/Reservation";

function App() {
  return (
    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    // </div>
    <Router>
      <div className="App">
        <Header />
        
        <Routes>
          <Route path="/" Component={Home}/>
          <Route path="/user/reservation" Component={Reservation}/>
          <Route path="/management/roomDetails" Component={RoomDetailManagement}/>
          <Route path="/management/roomDetails/addRoomDetails" Component={RoomDetailForm}/>
          <Route path="/management/roomDetails/addRooms" Component={RoomForm}/>
          <Route path="/management/roomDetails/addImage" Component={ImageForm}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
