package logger;

import java.io.IOException;
import java.util.Map;
import java.util.function.*;
public abstract class BaseLogger implements Logger {

    protected static final Map<Format, String> correctFormats = Map.of(
        Format.TIME, "HH:MM:SS",
        Format.DATE, "DD.MM.YYYY"
    );
    
    protected static final Map<Format, Function<String, Boolean>> formatCheck = Map.of(
        Format.TIME, BaseLogger :: isTime,
        Format.DATE, BaseLogger :: isDate
    ); 

    public abstract void log(String message) throws IOException;
    public void log(String message, Throwable cause) throws IOException {
        log(message + " caused by " + cause);
    }

    protected static boolean between(int val, int botLimit, int topLimit) {
        return val >= botLimit && val <= topLimit;
    }

    public void log(String message, Format format) throws IOException {
        if (!correctFormats.containsKey(format)) {
            log(format + " is not supported");
        }
        if (formatCheck.get(format).apply(message)) {
            log(message);
        } else {
            log("Incorrect format\n The correct format is " + correctFormats.get(format));
        }
    }

    protected static boolean isTime(String str) {
        if (str.length() != 8 || str.charAt(2) != ':' || str.charAt(5) != ':') {
            return false;
        }
        try {
            int hours = Integer.parseInt(str.substring(0, 2));
            int minutes = Integer.parseInt(str.substring(3, 5));
            int seconds = Integer.parseInt(str.substring(6, 8));
            return between(hours, 0, 23) && between(minutes, 0, 59) && between(seconds, 0, 59);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected static boolean isDate(String str) {
        if (str.length() != 10 || str.charAt(2) != '.' || str.charAt(5) != '.') {
            return false;
        }
        try {
            int day = Integer.parseInt(str.substring(0, 2));
            int month = Integer.parseInt(str.substring(3, 5));
            int year = Integer.parseInt(str.substring(6, 10));
            return isCorrectDate(day, month, year);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected static boolean isCorrectDate(int day, int month, int year) {
        if (!between(month, 1, 12) || !between(year, 0, 9999)) {
            return false;
        }
        if (month == 2) {
            if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
                return between(day, 0, 29);
            } else {
                return between(day, 0, 28);
            }
        } 
        return between(day, 0, 30 + (month <= 7 ? month % 2 : (month + 1) % 2));
    }



}