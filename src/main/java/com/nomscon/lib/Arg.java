package com.nomscon.lib;

import com.nomscon.lib.exceptions.ValueNotInDateRangeException;
import com.nomscon.lib.exceptions.ValueNotInRangeException;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Pattern;

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
public final class Arg {
    // TODO: add String errorMessage option to each check
    // see about using java.util.Optional 
    // NOTE: requires Java 8, soprobably not, just overload
    // TODO: unit tests

    private Arg() { /* disallow instantiation */ }
    
    public static void checkIsElementIndex(int index, int size) {
        if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException();
    }

    public static <T> void checkIsInCollection(T item, Collection<T> items) {
        checkIsNotNull(item);
        checkIsNotNull(items);
        if (items.isEmpty())
            throw new IllegalArgumentException("Collection cannot be empty.");

        for (T i : items) {
            if (item.equals(i)) {
                // Yeah! Found it
                return;
            }
        }

        throw new IllegalArgumentException(); // TODO: better exception???
    }
    
    public static void CheckIsInDateRange(Date value, Date rangeMin, Date rangeMax) {
        if (rangeMax.before(rangeMin)) {
        Date tempLimit = rangeMin;
        rangeMin = rangeMax;
        rangeMax = tempLimit;
        }

        if (value.before(rangeMin) || value.after(rangeMax))
        throw new ValueNotInDateRangeException(value, rangeMin, rangeMax);
    }

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

    public static void checkIsAMatch(String text, Pattern pattern) {
        checkIsNotNull(text);
        checkIsNotNull(pattern);

        if (!pattern.matcher(text).matches()) {
        throw new IllegalArgumentException(
            String.format("The specifed text '%s' must match the pattern '%s'"
                    , text, pattern.pattern()));
        }
    }

    public static void checkIsAMatch(String text, String patternString) {
        checkIsNotNull(patternString);

        Pattern pattern = Pattern.compile(patternString);
        checkIsAMatch(text, pattern);
    }

    public static <T> void checkIsNotInCollection(T item, Collection<T> items) {
        checkIsNotNull(item);
        checkIsNotNull(items);
        if (items.isEmpty())
            throw new IllegalArgumentException("Collection cannot be empty.");

        for (T i : items) {
            if (item.equals(i)) {
                // Oops! Found it
                throw new IllegalArgumentException(); // TODO: better exception???
            }
        }
    }
    
    public static void checkIsNotAMatch(String text, Pattern pattern) {
        checkIsNotNull(text);
        checkIsNotNull(pattern);

        if (pattern.matcher(text).matches()) {
            throw new IllegalArgumentException(
            String.format("The specifed text '%s' must NOT match the pattern '%s'"
                    , text, pattern.pattern()));
        }
    }

    public static void checkIsNotAMatch(String text, String patternString) {
        checkIsNotNull(patternString);

        Pattern pattern = Pattern.compile(patternString);
        checkIsNotAMatch(text, pattern);
    }

    public static void checkIsNotNull(Object value) {
        checkIsNotNull(value, null);
    }

    public static void checkIsNotNull(Object value, String errorMessage) {
        if (value == null)
            throw new NullPointerException(errorMessage);
    }

    public static void checkIsNotNullOrEmpty(String value) {
        checkIsNotNullOrEmpty(value, null);
    }

    public static void checkIsNotNullOrEmpty(String value, String errorMessage) {
        checkIsNotNull(value, errorMessage);
        if (value.isEmpty())
            throw new IllegalArgumentException(errorMessage);
    }

    public static void checkIsNotNullOrWhitespace(String value) {
        checkIsNotNullOrEmpty(value);
        boolean hasOnlyWhitespaceChars = true;
        // TODO: should be use .charAt
        for (Character c : value.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                hasOnlyWhitespaceChars = false;
                break;
            }
        }
        if (hasOnlyWhitespaceChars)
            throw new IllegalArgumentException();
    }

    public static void checkIsPositive(int value) {
        if (value <= 0)
            throw new ValueNotInRangeException(value, 1, Integer.MAX_VALUE);
    }

    public static void checkIsPositiveOrZero(int value) {
        if (value < 0)
            throw new ValueNotInRangeException(value, 0, Integer.MAX_VALUE);
    }

    public static void checkIsTrue(boolean condition) {
        if (!condition)
            throw new IllegalArgumentException();
    }
}

