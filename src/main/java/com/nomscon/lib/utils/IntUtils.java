package com.nomscon.lib.utils;

public final class IntUtils {
    private IntUtils() { /* cannot be instantiated */ }

    public static boolean isInRange(int value, int minValue, int maxValue) {
        if (maxValue < minValue) {
            int tempLimit = minValue;
            minValue = maxValue;
            maxValue = tempLimit;
        }

        return (value >= minValue && value <= maxValue);
    }
}