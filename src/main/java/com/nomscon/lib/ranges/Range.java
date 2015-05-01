/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.ranges;

public interface Range<T> {
    T getMin();
    T getMax();
    boolean isInclusive();
    boolean isInRange(T value);
    long length(); 
}
