package com.nomscon.lib.utils;

import com.nomscon.lib.Arg;
import com.nomscon.lib.exceptions.PendingImplementationException;

/**
 * Provides utility methods for dealing with strings.
 * <p>
 * <strong>NOTE:</strong><br>
 * most methods that return a String will return an empty string when the
 * specified text is null. Exceptions to this will be noted on the docs for the
 * method.
 */
public final class StringUtils {

    private StringUtils() { /* cannot be instantiated */ }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
    
    public static boolean isNullOrWhitespace(String value) {
        if (isNullOrEmpty(value))
            return true;
        boolean hasOnlyWhitespaceChars = true;
        int valueLen = value.length();
        for (int i = valueLen - 1; i >= 0; i--) {
            char c = value.charAt(i);
            if (!Character.isWhitespace(c)) {
                hasOnlyWhitespaceChars = false;
                break;
            }
        }
        return hasOnlyWhitespaceChars;
    }

    public static String padCenter(String value, char padChar, int length) {
        Arg.checkIsPositive(length);
        if (value == null)
            return "";
        if (value.length() >= length)
            return value;

        // TODO:
        throw new PendingImplementationException();
    }

    public static String padRight(String value, char padChar, int length) {
        Arg.checkIsPositive(length);
        if (value == null)
            return "";
        if (value.length() >= length)
            return value;

        String padding = repeat(padChar, length - value.length());
        return value + padding;
    }

    public static String padLeft(String value, char padChar, int length) {
        Arg.checkIsPositive(length);
        if (value == null)
            return "";
        if (value.length() >= length)
            return value;

        String padding = repeat(padChar, length - value.length());
        return padding + value;
    }

    public static String repeat(char c, int count) {
        Arg.checkIsPositiveOrZero(count);
        if (count == 0)
            return "";
        if (count == 1)
            return String.valueOf(c);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String repeat(String value, int count) {
        Arg.checkIsPositiveOrZero(count);
        if (count == 0 || isNullOrEmpty(value))
            return "";
        if (count == 1)
            return value;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value);
        }
        return sb.toString();
    }

    // TODO: testTrimRightWith ... Null, EmptyString, NoWhitespace, 
    // WhitespaceOnRightOnly, WhitespaceOnLeftOnly,
    // WhitespaceOnBothEnds
    public static String trimRight(String value) {
        if (isNullOrWhitespace(value))
            return "";

        int valueLen = value.length();
        int lastWhitespaceIndex = valueLen;

        for (int i = valueLen - 1; i >= 0; i--) {
            char c = value.charAt(i);
            if (!Character.isWhitespace(c)) {
                lastWhitespaceIndex = i + 1;
                break;
            }
        }

        if (lastWhitespaceIndex >= valueLen)
            return value;

        return (value.substring(0, lastWhitespaceIndex));
    }

    public static String trimLeft(String value) {
        if (isNullOrWhitespace(value))
            return "";

        int valueLen = value.length();
        int lastWhitespaceIndex = 0;

        for (int i = 0; i < valueLen; i++) {
            char c = value.charAt(i);
            if (!Character.isWhitespace(c)) {
                lastWhitespaceIndex = i;
                break;
            }
        }

        if (lastWhitespaceIndex >= valueLen)
            return value;

        return (value.substring(lastWhitespaceIndex));
    }

    public static String truncateCenter(String value, int length) {
        Arg.checkIsPositiveOrZero(length);
        if (length == 0 || isNullOrEmpty(value))
            return "";
        // TODO:
        throw new PendingImplementationException();
    }

    public static String truncateRight(String value, int length) {
        Arg.checkIsPositiveOrZero(length);
        if (length == 0 || isNullOrEmpty(value))
            return "";
        return (value.length() <= length)
                ? value
                : value.substring(0, length);
    }

    public static String truncateLeft(String value, int length) {
        Arg.checkIsPositiveOrZero(length);
        if (length == 0 || isNullOrEmpty(value))
            return "";
        int valueLen = value.length();
        return (valueLen <= length)
                ? value
                : value.substring(valueLen - length);
    }
}
