package com.maruliastra.maruli.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TimeUtil {

    public static Date getSystemDateTime() {
        Calendar calendar = new GregorianCalendar();
        return getDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
    }

    public static Date getDate(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
        Calendar calendar = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
        calendar.setLenient(false);
        return calendar.getTime();
    }

    public static Date convertStringToDate(String dateStr, String pattern) {
        try {
            return new SimpleDateFormat(pattern, Locale.ENGLISH).parse(dateStr);
        } catch (ParseException e) {

        }
        return null;
    }

}
