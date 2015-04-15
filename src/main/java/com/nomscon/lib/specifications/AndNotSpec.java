/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.specifications;

public class AndNotSpec<T> extends CompositeSpec<T> {
    public AndNotSpec(Spec<T> leftSpec, Spec<T> rightSpec) {
        super(leftSpec, rightSpec);
    }
    
    @Override
    public boolean isSatisfiedBy(T item) {
        boolean result = getFirstSpecification().isSatisfiedBy(item);
        if (result) {
            // only evaluate otherSpec if satisfied by first
            result = !getOtherSpecification().isSatisfiedBy(item);
        }
        return result;
    }
}
