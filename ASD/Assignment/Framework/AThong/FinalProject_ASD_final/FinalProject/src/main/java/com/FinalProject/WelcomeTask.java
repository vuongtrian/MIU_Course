package com.FinalProject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class WelcomeTask {
    @Scheduled(fixedRate = 5000)
    public void welcome() {
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);String currenttime = timeFormatter.format(date);
        System.out.println("This task runs at " + currenttime);
    }
}
