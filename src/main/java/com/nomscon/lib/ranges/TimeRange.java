/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.ranges;

import java.time.LocalTime;

public class TimeRange extends AbstractRange<LocalTime> {

    // creates and exclusive or half-open range
    public static TimeRange create(LocalTime startTime, LocalTime endTime) {
        return new TimeRange(startTime, endTime, false);
    }

    // creates and inclusive or closed range
    public static TimeRange createInclusive(LocalTime startTime, LocalTime endTime) {
        return new TimeRange(startTime, endTime, true);
    }

    private TimeRange(LocalTime minTime, LocalTime maxTime, boolean inclusive) {
        super(minTime, maxTime, inclusive);
    }
}

