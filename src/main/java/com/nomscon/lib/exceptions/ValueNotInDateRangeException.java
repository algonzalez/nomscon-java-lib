/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.exceptions;

import java.util.Date;

public class ValueNotInDateRangeException extends RuntimeException {
    private static final String DEFAULT_MESSAGE_TEMPLATE = "value %s is not in range of %s..%s";

    private final Date value;
    private final Date rangeMin;
    private final Date rangeMax;

    public ValueNotInDateRangeException(Date value, Date rangeMin, Date rangeMax) {
        this(value, rangeMin, rangeMax
                , String.format(DEFAULT_MESSAGE_TEMPLATE, value, rangeMin, rangeMax));
    }

    public ValueNotInDateRangeException(Date value, Date rangeMin, Date rangeMax, String message) {
        super(message != null && !message.isEmpty()
                ? message
                : String.format(DEFAULT_MESSAGE_TEMPLATE, value, rangeMin, rangeMax));
        this.value = value;
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
    }

    public ValueNotInDateRangeException(Date value, Date rangeMin, Date rangeMax, String message, Throwable cause) {
        super(message != null && !message.isEmpty()
                ? message
                : String.format(DEFAULT_MESSAGE_TEMPLATE, value, rangeMin, rangeMax), cause);
        this.value = value;
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;    }
    
    public ValueNotInDateRangeException(Throwable cause) {
        super(cause);
        this.value = null;
        this.rangeMin = null;
        this.rangeMax = null;
    }

    public Date getValue() { return value; }

    public Date getRangeMin() { return rangeMin; }

    public Date getRangeMax() { return rangeMax; }
}
