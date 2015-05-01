/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.utils;

import com.nomscon.lib.Arg;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public final class DateUtils {
    private DateUtils() { /* cannot be instantiated */ }
    
    // TODO: ??? getMonthsBetween, getDaysBetween 
    //       might be better to use the until methods

    public static int daysUntil(int day) {
        return daysUntil(day, LocalDate.now());
    }
    
    public static int daysUntil(int day, LocalDate fromDate) {
        // TODO: handle varying month lengths better.
        
        Arg.checkIsNotNull(fromDate);
        Arg.checkIsPositive(day);
        if (day > 31) 
            throw new IllegalArgumentException();
        
        int curDay = fromDate.getDayOfMonth();
        if (curDay < day) return day - curDay;
        int lastDay = fromDate.lengthOfMonth();
        LocalDate nextMonth = fromDate.plusMonths(1);
        LocalDate nextDate = nextMonth.withDayOfMonth(day);
        return (lastDay = curDay) + day;
    }
    
    public static Period getAge(LocalDate birthDate) {
        return getAge(birthDate, LocalDate.now());
    }
    
    public static Period getAge(LocalDate birthDate, LocalDate asOfDate) {
        Arg.checkIsNotNull(birthDate);
        Arg.checkIsNotNull(asOfDate);
        return birthDate.until(asOfDate);
    }
    
    // TODO: test with Feb 29
    public static LocalDate getNext(int month, int day) {
        return getNext(month, day, LocalDate.now());
    }

    public static LocalDate getNext(int month, int day, LocalDate fromDate) {
        if (!isValidDay(month, day))
            throw new IllegalArgumentException();
        
        int year = fromDate.getYear();
        while (!isValidDay(year, month, day)
                || !LocalDate.of(year, month, day).isAfter(fromDate)) {
            year++;
        }
        
        return LocalDate.of(year, month, day);
    }

    public static LocalDate getLast(int month, int day) {
        return getLast(month, day, LocalDate.now());
    }
    
    public static LocalDate getLast(int month, int day, LocalDate fromDate) {
        if (!isValidDay(month, day))
            throw new IllegalArgumentException();
        
        int year = fromDate.getYear();
        while (!isValidDay(year, month, day)
                || !LocalDate.of(year, month, day).isBefore(fromDate)) {
            year--;
        }
        
        return LocalDate.of(year, month, day);
    }

    // TODO: switch to use LocalDate, LocalDateTime and LocalTime
    // TODO: handle inclusive/exclusive
    // TODO: return (startDate.equals(date) || startDate.isBefore(date))
    //               && (endDate.equals(date) || endDate.isAfter(date));
    public static boolean isInRange(Date value, Date minValue, Date maxValue) {
        Arg.checkIsNotNull(value);
        Arg.checkIsNotNull(minValue);
        Arg.checkIsNotNull(maxValue);
        
        if (maxValue.before(minValue)) {
            Date tempLimit = minValue;
            minValue = maxValue;
            maxValue = tempLimit;
        }

        return (value.equals(minValue) 
                || value.equals(maxValue)
                || (value.after(minValue)) && value.before(maxValue));
    }
    
    public static boolean isValidDay(int month, int day) {
        Arg.checkIsInRange(month, 1, 12);
        if (day < 1 || day > 31) return false;
        // Feb is special
        if (month == 2) return day < 30;
        // months with 30 days
        if (month == 4 || month == 6
                || month == 9 || month == 11) return day < 31;
        return true;
    }
    
    public static boolean isValidDay(int year, int month, int day) {
        Arg.checkIsInRange(month, 1, 12);
        Arg.checkIsPositive(year);
        if (day < 1 || day > 31) return false;
        
        LocalDate date = LocalDate.of(year, month, 1);
        return (day <= date.lengthOfMonth());
    }
    
    public static boolean isValidMonth(int month) {
        return month > 0 && month <13;
    }

    // LocalDate helpers
    // =================
    public static LocalDate yesterday() { return LocalDate.now().minusDays(1); }
    public static LocalDate today() { return LocalDate.now(); }
    public static LocalDate tomorrow() { return LocalDate.now().plusDays(1); }
    
    public static LocalDate lastMonth() { return LocalDate.now().minusMonths(1); }
    public static LocalDate nextMonth() { return LocalDate.now().plusMonths(1); }
    
    public static LocalDate lastYear() { return LocalDate.now().minusYears(1); }
    public static LocalDate nextYear() { return LocalDate.now().plusYears(1); }
    
    // LocalDateTime helpers
    // =====================
    public static LocalDateTime atMidnight(LocalDateTime value) {
        return value != null ? value.truncatedTo(ChronoUnit.DAYS) : null;
    }
    
    public static LocalDateTime atEndOfDay(LocalDateTime value) {
        return value != null ? atMidnight(value.plusDays(1)).minusMinutes(1) : null;
    }
    
    public static LocalDateTime atStartOfDay(LocalDateTime value) {
        return atMidnight(value);
    }
    
    // LocalTime helpers
    // =================
    
    // ??? LocalTime midnight(), endOfDay, startOfDay
}
