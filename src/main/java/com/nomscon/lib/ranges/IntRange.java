/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntRange extends AbstractRange<Integer> implements Iterable<Integer> {

    // creates and exclusive or half-open range
    public static IntRange create(Integer minValue, Integer maxValue) {
        return new IntRange(minValue, maxValue, false);
    }

    // creates and inclusive or closed range
    public static IntRange createInclusive(Integer minValue, Integer maxValue) {
        return new IntRange(minValue, maxValue, true);
    }

    private IntRange(int minValue, int maxValue, boolean inclusive) {
        super(minValue, maxValue, inclusive);
    }

    @Override
    public Iterator<Integer> iterator() { return new IntRangeIterator(); }

    private class IntRangeIterator implements Iterator<Integer> {
        private int nextValue;
        private final int lastValue;

        public IntRangeIterator() {
            nextValue = getMinValue();
            lastValue = isInclusive() ? getMaxValue() + 1 :getMaxValue();
        }

        @Override
        public boolean hasNext() {
            return nextValue < lastValue;
        }

        @Override
        public Integer next() {
            if (hasNext())
            {
                nextValue++;
                return nextValue;
            }
            throw new NoSuchElementException();
        }
    }
}
