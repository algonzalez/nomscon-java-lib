/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.ranges;

// TOOD:

import java.time.LocalTime;
import java.util.Iterator;

public class TimeRange implements Range<LocalTime>, Iterable<LocalTime> {

    @Override
    public LocalTime getMin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LocalTime getMax() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isInclusive() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isInRange(LocalTime value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long length() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<LocalTime> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

