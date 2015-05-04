/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.ranges;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DateRange extends AbstractRange<LocalDate> implements  Iterable<LocalDate> {

    // creates and exclusive or half-open range
    public static DateRange create(LocalDate startDate, LocalDate endDate) {
        return new DateRange(startDate, endDate, false);
    }
    
    // creates and inclusive or closed range
    public static DateRange createInclusive(LocalDate startDate, LocalDate endDate) {
        return new DateRange(startDate, endDate, true);
    }
    
    private DateRange(LocalDate minDate, LocalDate maxDate, boolean inclusive) {
        super(minDate, maxDate, inclusive);
    }
    
    @Override
    public Iterator<LocalDate> iterator() { return new DateRangeIterator(); }

    private class DateRangeIterator implements Iterator<LocalDate> {
        private LocalDate nextDate;
        private final LocalDate lastDate;
        
        public DateRangeIterator() {
            nextDate = getMinValue();
            lastDate = getMaxValue().plusDays(isInclusive() ? 1 : 0);
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
