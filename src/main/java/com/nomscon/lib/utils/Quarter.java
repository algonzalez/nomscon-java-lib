/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.utils;

import com.nomscon.lib.Arg;
import java.time.LocalDate;

/*
for (Quarter q : Quarter.values()) {
    System.out.println(String.format("%-8s: %s - %s (%s days)"
            , q, q.getStartDate(), q.getEndDate(), q.lengthOfQuater()));
}
*/
public enum Quarter {
    FIRST(1),
    SECOND(4),
    THIRD(7),
    FOURTH(10);
    
    private final int startingMonth;
    
    Quarter(int startingMonth) {
        this.startingMonth = startingMonth;
    }

    public int getStartingMonth() { return startingMonth; }
    
    public LocalDate getStartDate() {
        return getStartDateForYear(LocalDate.now().getYear());
    }
    
    public LocalDate getEndDate() {
        return getEndDateForYear(LocalDate.now().getYear());
    }
    
    public int lengthOfQuarter() {
        return lengthOfQuarterForYear(LocalDate.now().getYear());
    }

    private LocalDate getStartDateForYear(int year) {
        Arg.checkIsNotZero(year);
        return LocalDate.of(year, startingMonth, 1);
    }

    private LocalDate getEndDateForYear(int year) {
        Arg.checkIsNotZero(year);
        return getStartDateForYear(year).plusMonths(3).minusDays(1);
    }

    private int lengthOfQuarterForYear(int year) {
        LocalDate start = getStartDateForYear(year);
        return start.lengthOfMonth()
                + start.plusMonths(1).lengthOfMonth()
                + start.plusMonths(2).lengthOfMonth();
    }
    
    public static Quarter forDate(LocalDate date) {
        Arg.checkIsNotNull(date);
        int month = date.getMonthValue();
        if (month < Quarter.SECOND.startingMonth) return Quarter.FIRST;
        if (month < Quarter.THIRD.startingMonth) return Quarter.SECOND;
        if (month < Quarter.FOURTH.startingMonth) return Quarter.THIRD;
        return Quarter.FOURTH;
    }
}
