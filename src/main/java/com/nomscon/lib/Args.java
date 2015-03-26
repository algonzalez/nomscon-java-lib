package com.nomscon.lib;

import com.nomscon.lib.exceptions.ValueNotInRangeException;

/**
 * Provides utility methods to validate arguments
 * <p>
 * Example:
 * <pre>
 * public void invokeAction(String actionName, int repeatCount) {
 *   Args.checkIsNotNullOrEmpty(actionName);
 *   Args.checkIsInRange(repeatCount, 1, 4);
 *   // ... method body
 * </pre>
 */
public final class Args {
    /**
     * Ensure that the specified value is between the lowLimit and highLimit, inclusive
     * <p>
     * @param value argument value to validate
     * @param rangeMin minimum value allowed
     * @param rangeMax maximum value allowed
     */
    public static void checkIsInRange(int value, int rangeMin, int rangeMax) {
        if (rangeMax < rangeMin) {
            int tempLimit = rangeMin;
            rangeMin = rangeMax;
            rangeMax = tempLimit;
        }

        if (value < rangeMin || value > rangeMax)
            throw new ValueNotInRangeException(value, rangeMin, rangeMax);
    }

    public static void checkIsNotNull(Object value) {
        if (value == null)
            throw new NullPointerException();
    }

    public static void checkIsNotNullOrEmpty(String value) {
        if (value == null)
            throw new NullPointerException();
        if (value.isEmpty())
            throw new IllegalArgumentException();
    }

    public static void checkIsNotNullOrWhitespace(String value) {
        checkIsNotNullOrEmpty(value);
        boolean hasOnlyWhitespaceChars = true;
        for (Character c : value.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                hasOnlyWhitespaceChars = false;
                break;
            }
        }
        if (hasOnlyWhitespaceChars)
            throw new IllegalArgumentException();
    }

    private Args() { /* disallow instantiation */ }
}

