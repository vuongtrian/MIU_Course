package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class TimeSchedule {

    @Autowired
    private Logger logger;

    @Scheduled(fixedRate = 15000)
    public void printTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);String currenttime = timeFormatter.format(date);
        logger.log("This task runs at " + currenttime);
    }
}
