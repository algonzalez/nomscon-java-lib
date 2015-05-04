/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.ranges;

import com.nomscon.lib.Arg;

public abstract class AbstractRange<T extends Comparable<? super T>> implements Range<T> {
    private final T minValue;
    private final T maxValue;
    private final boolean inclusive;  // if true range is closed [min..max] else range is half-open [min..max))

    protected AbstractRange(T minValue, T maxValue, boolean inclusive) {
        Arg.checkIsNotNull(minValue);
        Arg.checkIsNotNull(maxValue);

        Arg.checkIsTrue(maxValue.compareTo(minValue) < 0
                , String.format("max value cannot be less than min value - (%s..%s)", minValue, maxValue));

        if (!inclusive && minValue.equals(maxValue))
            throw new IllegalArgumentException(
                    String.format("min and max values cannot be equal in an exclusive/half-open range - (%s)", getMinValue()));

        this.minValue = minValue;
        this.maxValue = maxValue;
        this.inclusive = inclusive;
    }

    @Override
    public T getMinValue() { return minValue; }

    @Override
    public T getMaxValue() { return maxValue; }

    @Override
    public boolean isInclusive() { return inclusive; }

    @Override
    public boolean isInRange(T value) {
        Arg.checkIsNotNull(value);

        return (value.compareTo(minValue) >= 0
                && value.compareTo(maxValue) < 0)
                || (inclusive && value.equals(maxValue));
    }
}
