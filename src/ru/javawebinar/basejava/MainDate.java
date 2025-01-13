package ru.javawebinar.basejava;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainDate {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Date date = new Date();
        System.out.println("Date: " + date);
        System.out.println("Millis: " + (System.currentTimeMillis() - start));

        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        System.out.println("Calendar: " + cal.getTime());

        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        System.out.println("LocalDate: " + ld + " LocalTime: " + lt);
        System.out.println("LocalDateTime: " + ldt);

        SimpleDateFormat sdf = new SimpleDateFormat("YY/MM/dd");
        System.out.println("SimpleDateFormat: " + sdf.format(date));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY/MM/dd");
        System.out.println("DateTimeFormatter: " + dtf.format(ldt));
    }
}
