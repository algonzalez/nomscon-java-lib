package com.nomscon.lib.exceptions;

/**
 * 
 */
public class ValueNotInRangeException extends IllegalArgumentException {
    private static final String messageFormat = "value %d is not in range of %d..%d";

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
