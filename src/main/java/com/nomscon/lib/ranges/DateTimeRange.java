/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.ranges;

// TODO:

import java.time.LocalDate;
import java.util.Iterator;

public class DateTimeRange implements Range<LocalDate>, Iterable<LocalDate> {

    @Override
    public LocalDate getMin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LocalDate getMax() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isInclusive() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isInRange(LocalDate value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long length() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<LocalDate> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
