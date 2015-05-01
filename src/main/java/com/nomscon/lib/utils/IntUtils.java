/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.utils;

import com.nomscon.lib.Arg;

public final class IntUtils {
    private IntUtils() { /* cannot be instantiated */ }

    public static String asOrdinal(int value) {
        return String.format("%d%s", value, getOrdinalSuffix(value));
    }
    
    public static String getOrdinalSuffix(int value) {
        Arg.checkIsPositiveOrZero(value);
        if (value > 3 && value < 21) return "th";
        switch (value % 10) {
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    }
    
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