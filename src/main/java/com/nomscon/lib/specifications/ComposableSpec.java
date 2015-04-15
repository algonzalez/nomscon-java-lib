/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.specifications;

import com.nomscon.lib.Arg;

public final class ComposableSpec<T> implements Spec<T>{
    private Spec<T> compositeSpec = null;

    public ComposableSpec(Spec<T> baseSpec) {
        Arg.checkIsNotNull(baseSpec);
        compositeSpec = baseSpec;
    }
       
    public ComposableSpec<T> and(Spec<T> spec) {
        compositeSpec = new AndSpec<>(compositeSpec, spec);
        return this;
    }

    public ComposableSpec<T> or(Spec<T> spec) {
        compositeSpec = new OrSpec<>(compositeSpec, spec);
        return this;
    }
    
    public ComposableSpec<T> andNot(Spec<T> spec) {
        compositeSpec = new AndNotSpec<>(compositeSpec, spec);
        return this;
    }

    public ComposableSpec<T> orNot(Spec<T> spec) {
        compositeSpec = new OrNotSpec<>(compositeSpec, spec);
        return this;
    }

    @Override
    public boolean isSatisfiedBy(T item) {
        return compositeSpec.isSatisfiedBy(item);
    }
}
