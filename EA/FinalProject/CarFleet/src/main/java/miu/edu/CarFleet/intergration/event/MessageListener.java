package miu.edu.CarFleet.intergration.event;

import miu.edu.CarFleet.domain.Car;
import miu.edu.CarFleet.service.CarService;
import miu.edu.CarFleet.service.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageListener {

    @Autowired
    private CarService carService;

    @JmsListener(destination = "ReservedCar")
    public void receiveMessage (String message) {
        System.out.println("Received: " + message);

        String[] messageArray = message.split(" ");
        String licensePlate = messageArray[messageArray.length-1];
        CarDTO car = carService.getOneCar(licensePlate);
        List<CarDTO> getAllAvailableCar = carService.getCarStatusByTypeAndBrand(car.getType(), car.getBrand(), "available");
        if(getAllAvailableCar.size() < 3) {
            System.out.println("Send email to fleet manager: " +
                    "Car type: " + car.getType() +
                    " - brand: " + car.getBrand() +
                    " is available " + getAllAvailableCar.size() +
                    " cars");
        }
    }
}
