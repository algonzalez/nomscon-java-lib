/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.specifications;

public class OrNotSpec<T> extends CompositeSpec<T> {
    public OrNotSpec(Spec<T> leftSpec, Spec<T> rightSpec) {
        super(leftSpec, rightSpec);
    }
    
    @Override
    public boolean isSatisfiedBy(T item) {
        return getFirstSpecification().isSatisfiedBy(item)
                || !getOtherSpecification().isSatisfiedBy(item);
    }
}
