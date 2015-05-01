/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.exceptions;

public class ValueNotInRangeException extends RuntimeException {
    private static final String messageFormat = "value %d must be in the range of %d..%d";

    private final int value;
    private final int rangeMin;
    private final int rangeMax;

    /**
     * CTOR
     * <p>
     * @param value the value that fell outside of the range
     * @param rangeMin the minimum value allowed for the range
     * @param rangeMax the maximum value allowed for the range
     */
    public ValueNotInRangeException(int value, int rangeMin, int rangeMax) {
        this(value, rangeMin, rangeMax
                , String.format(messageFormat, value, rangeMin, rangeMax));
    }

    public ValueNotInRangeException(int value, int rangeMin, int rangeMax, String message) {
        super(message != null && !message.isEmpty()
                ? message
                : String.format(messageFormat, value, rangeMin, rangeMax));
        this.value = value;
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
    }
    
    public ValueNotInRangeException(int value, int rangeMin, int rangeMax, String message, Throwable cause) {
        super(message != null && !message.isEmpty()
                ? message
                : String.format(messageFormat, value, rangeMin, rangeMax), cause);
        this.value = value;
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
    }
    
    public ValueNotInRangeException(Throwable cause) {
        super(cause);
        this.value = 0;
        this.rangeMin = 0;
        this.rangeMax = 0;
    }

    /**
     * 
     * @return the value that fell outside of the range
     */
    public int getValue() { return value; }
    
    /**
     * 
     * @return the minimum value allowed for the range 
     */
    public int getRangeMin() { return rangeMin; }
    
    /**
     * 
     * @return the maximum value allowed for the range
     */
    public int getRangeMax() { return rangeMax; }
}
