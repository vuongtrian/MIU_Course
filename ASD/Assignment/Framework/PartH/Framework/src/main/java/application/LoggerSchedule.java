package application;

import java.text.DateFormat;
import java.util.Calendar;

import framework.Scheduled;
import framework.Service;

@Service
public class LoggerSchedule {
	
//	@Scheduled(fixedRate = 2000)
	public void scheduleWithFixedRate() {
        System.out.println("This task runs at " + DateFormat.getTimeInstance(DateFormat.DEFAULT).format(Calendar.getInstance().getTime()));
	}
	
	@Scheduled(cron = "5 0")
	public void scheduleWithCron() {
		System.out.println("This task runs at " + DateFormat.getTimeInstance(DateFormat.DEFAULT).format(Calendar.getInstance().getTime()));
	}

}
