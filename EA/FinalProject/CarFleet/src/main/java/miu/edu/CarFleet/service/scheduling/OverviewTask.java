package miu.edu.CarFleet.service.scheduling;

import miu.edu.CarFleet.domain.Car;
import miu.edu.CarFleet.service.ICarService;
import miu.edu.CarFleet.service.dto.CarAdapter;
import miu.edu.CarFleet.service.dto.CarDTO;
import miu.edu.CarFleet.service.dto.CarDTOList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class OverviewTask {

    Logger logger = LoggerFactory.getLogger(OverviewTask.class);

    @Autowired
    private ICarService carService;

    @Scheduled(fixedRate = 20000)
    public void overviewCar() {
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        String currentTime = timeFormatter.format(date);
        System.out.println("This task runs at " + currentTime);
        List<CarDTO> cars = carService.getAllCar();
        CarDTOList carDTOList = new CarDTOList(cars);
        System.out.println(carDTOList);
        logger.info("This task runs at " + currentTime + ": " +carDTOList.toString());
    }
}
