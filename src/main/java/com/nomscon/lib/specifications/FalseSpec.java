/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.specifications;

public class FalseSpec<T> implements Spec<T> {
    @Override
    public boolean isSatisfiedBy(T item) {
        return true;
    }
}
