/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.ranges;

import com.nomscon.lib.Arg;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DateRange implements Range<LocalDate>, Iterable<LocalDate> {
    private final LocalDate minDate;
    private final LocalDate maxDate;
    private final boolean inclusive;  // if true range is closed [min..max] else range is half-open [min..max))

    // creates and exclusive or half-open range
    public static DateRange create(LocalDate startDate, LocalDate endDate) {
        return new DateRange(startDate, endDate, false);
    }
    
    // creates and exclusive or half-open range
    public static DateRange create(LocalDate startDate, int daysInRange) {
        Arg.checkIsNotNull(startDate);
        Arg.checkIsPositiveOrZero(daysInRange);
        return new DateRange(startDate, startDate.plusDays(daysInRange), false);
    }

    // creates and inclusive or closed range
    public static DateRange createInclusive(LocalDate startAndEndDate) {
        return createInclusive(startAndEndDate, startAndEndDate);
    }
    
    // creates and inclusive or closed range
    public static DateRange createInclusive(LocalDate startDate, LocalDate endDate) {
        return new DateRange(startDate, endDate, true);
    }
    
    public static DateRange createInclusive(final LocalDate startDate, int daysInRange) {
        Arg.checkIsNotNull(startDate);
        Arg.checkIsPositiveOrZero(daysInRange);
        return createInclusive(startDate, startDate.plusDays(daysInRange + 1));
    }

    private DateRange(LocalDate minDate, LocalDate maxDate, boolean inclusive) {
        Arg.checkIsNotNull(minDate);
        Arg.checkIsNotNull(maxDate);

        // uses .plusDays(0) to ensure that the time portion is consistent (Midnight)
        // NOTE: if time is relevant, use DateTimeRange
        this.minDate = minDate.plusDays(0);
        this.maxDate = maxDate.plusDays(0);
        this.inclusive = inclusive;
        
        if (!inclusive && this.minDate.equals(this.maxDate))
            throw new IllegalArgumentException(
                    String.format("min and max dates cannot be the same in an exclusive/half-open range - (%s)", this.minDate));
        
        Arg.checkIsTrue(!maxDate.isBefore(minDate)
                , String.format("max date cannot be before min date - (%s..%s)", this.minDate, this.maxDate));
    }
    
    @Override
    public LocalDate getMin() { return minDate; }
    @Override
    public LocalDate getMax() { return maxDate; }
    @Override
    public boolean isInclusive() { return this.inclusive; }

    public DateRange expandMin(int numberOfDays) {
        Arg.checkIsPositiveOrZero(numberOfDays);
        return new DateRange(minDate.minusDays(numberOfDays), maxDate, inclusive);
    }

    public DateRange expandMax(int numberOfDays) {
        Arg.checkIsPositiveOrZero(numberOfDays);
        return new DateRange(minDate, maxDate.plusDays(numberOfDays), inclusive);
    }

    public DateRange shrinkMin(int numberOfDays) {
        Arg.checkIsPositiveOrZero(numberOfDays);
        return new DateRange(minDate.plusDays(numberOfDays), maxDate, inclusive);
    }

    public DateRange shrinkMax(int numberOfDays) {
        Arg.checkIsPositiveOrZero(numberOfDays);
        return new DateRange(minDate, maxDate.minusDays(numberOfDays), inclusive);
    }
    
    @Override
    public long length() {
        return minDate.until(maxDate).getDays() + (inclusive ? 1 : 0);
    }

    @Override
    public boolean isInRange(LocalDate value) {
        Arg.checkIsNotNull(value);
        LocalDate dt = value.plusDays(0);
        return (dt.equals(minDate) || dt.isAfter(minDate))
                && dt.isBefore(maxDate.plusDays(inclusive ? 1 : 0));
    }

    @Override
    public Iterator<LocalDate> iterator() {
        return new DateRangeIterator();
    }

    private class DateRangeIterator implements Iterator<LocalDate> {
        private LocalDate nextDate;
        private final LocalDate lastDate;
        
        public DateRangeIterator() {
            nextDate = minDate;
            lastDate = inclusive ? maxDate.plusDays(1) : maxDate;
        }
        
        @Override
        public boolean hasNext() {
            return nextDate.isBefore(lastDate);
        }

        @Override
        public LocalDate next() {
            if (hasNext())
            {
                LocalDate currentDate = nextDate;
                nextDate = nextDate.plusDays(1);
                return currentDate;
            }
            throw new NoSuchElementException();
        }
    }
}
