/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.ranges;

import java.time.LocalDateTime;

public class DateTimeRange extends AbstractRange<LocalDateTime> {

    // creates and exclusive or half-open range
    public static DateTimeRange create(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return new DateTimeRange(startDateTime, endDateTime, false);
    }

    // creates and inclusive or closed range
    public static DateTimeRange createInclusive(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return new DateTimeRange(startDateTime, endDateTime, true);
    }

    private DateTimeRange(LocalDateTime minDateTime, LocalDateTime maxDateTime, boolean inclusive) {
        super(minDateTime, maxDateTime, inclusive);
    }
}
