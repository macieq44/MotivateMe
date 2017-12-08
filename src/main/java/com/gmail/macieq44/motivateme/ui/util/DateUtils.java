package com.gmail.macieq44.motivateme.ui.util;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Macieq44 on 28.11.2017.
 */
public class DateUtils {
    public static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM");
    public static final DateFormat WITH_DAY_FORMATTER = new SimpleDateFormat("dd-MM-yyyy");
    public static final DateFormat FULL_MONTH = new SimpleDateFormat("MMMMM d");
    public static final DateTimeFormatter format = DateTimeFormatter.ofPattern("MMMM d");
    private DateUtils() {}

    public static YearMonth getInstance(Date date) {
        return YearMonth.parse(FORMATTER.format(date));
    }

    public static int getNumberOfDays(Date date) {

        YearMonth yearMonthObj = YearMonth.parse(FORMATTER.format(date));

        return yearMonthObj.lengthOfMonth();
    }

    public static DayOfWeek getFirstDayOfMonth(YearMonth yearMonth) {
        LocalDate date = yearMonth.atDay(1);

        return date.getDayOfWeek();
    }

    public static String getDateAsString(String day, YearMonth yearMonth) {
        if (Integer.valueOf(day) <10) {
            day = "0" + day;
        }
        return yearMonth.toString() + "-" + day;
    }

    public static String getDateAsString(LocalDate date) {
        return date.format(format);
    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
