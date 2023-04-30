package miu.edu.CarRental.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateService {
    public static int countDate (Date fromDate, Date toDate){
        Calendar start = Calendar.getInstance();
        start.setTime(fromDate);

        Calendar end = Calendar.getInstance();
        end.setTime(toDate);

        int count = 0;
        while (!start.after(end)) {
            count++;
            start.add(Calendar.DATE, 1);
        }
        return count;
    }

    public static Date formatDate (String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }
}
