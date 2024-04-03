package com.FinalProject;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Welcome {
    @Scheduled(cron="5 0")
    public void welcome1() {
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);String currenttime = timeFormatter.format(date);
        System.out.println("This task runs at " + currenttime);
    }

    @Scheduled(cron="5 1")
    public void welcome2() {
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);String currenttime = timeFormatter.format(date);
        System.out.println("This task runs at " + currenttime);
    }

    @Scheduled(cron="7 5")
    public void welcome3() {
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);String currenttime = timeFormatter.format(date);
        System.out.println("This task runs at " + currenttime);
    }
}
