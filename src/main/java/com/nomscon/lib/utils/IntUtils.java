package com.nomscon.lib.utils;

public final class IntUtils {
    private IntUtils() { /* cannot be instantiated */ }

    public static boolean isEven(int value) {
        // check first bit which is only set for odd values
        // NOTE: can also check remainder when dividing by 2, 
        //       so return (value % 2) == 0 
        return (value & 1) == 0;
    }

    public static boolean isOdd(int value) {
        return !isEven(value);
    }

    public static boolean isInRange(int value, int minValue, int maxValue) {
        if (maxValue < minValue) {
            int tempLimit = minValue;
            minValue = maxValue;
            maxValue = tempLimit;
        }

        return (value >= minValue && value <= maxValue);
    }
}