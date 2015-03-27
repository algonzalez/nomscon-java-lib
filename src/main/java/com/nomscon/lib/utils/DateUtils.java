package com.nomscon.lib.utils;

import java.util.Date;

public class DateUtils {
    private DateUtils() { /* cannot be instantiated */ }
    
    public static boolean isInRange(Date value, Date minValue, Date maxValue) {
        if (maxValue.before(minValue)) {
            Date tempLimit = minValue;
            minValue = maxValue;
            maxValue = tempLimit;
        }

        return (value.equals(minValue) 
                || value.equals(maxValue)
                || (value.after(minValue)) && value.before(maxValue));
    }
}
