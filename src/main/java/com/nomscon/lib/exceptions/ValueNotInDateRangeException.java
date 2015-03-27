package com.nomscon.lib.exceptions;

import java.util.Date;

public class ValueNotInDateRangeException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE_TEMPLATE = "value %d is not in range of %d..%d";

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

    public Date getValue() { return value; }

    public Date getRangeMin() { return rangeMin; }

    public Date getRangeMax() { return rangeMax; }
}
