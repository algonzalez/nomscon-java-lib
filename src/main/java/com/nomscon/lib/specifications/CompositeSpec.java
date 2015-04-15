/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.specifications;

import com.nomscon.lib.Arg;

public abstract class CompositeSpec<T> implements Spec<T> {
    private final Spec<T> firstSpec;
    private final Spec<T> otherSpec;

    protected CompositeSpec(Spec<T> firstSpec, Spec<T> otherSpec) {
        Arg.checkIsNotNull(firstSpec);
        Arg.checkIsNotNull(otherSpec);

        this.firstSpec = firstSpec;
        this.otherSpec = otherSpec;
    }

    protected Spec<T> getFirstSpecification() { 
        return firstSpec;
    }

    protected Spec<T> getOtherSpecification() { 
        return otherSpec;
    }
}
