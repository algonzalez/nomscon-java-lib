/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib;

public class TryResult<TResult> {
    private final boolean isSuccess;
    private final TResult resultValue;
    private final Throwable exception;
    
    public static <T> TryResult<T> asSuccess(T value) {
        return new TryResult<>(true, value, null);
    }
    
    public static <T> TryResult<T> asFailure() {
        return new TryResult<>(false, null, null);
    }
    
    public static <T> TryResult<T> asFailure(Throwable ex) {
        return new TryResult<>(false, null, ex);
    }
    
    public static <T> TryResult<T> asFailure(T defaultValue, Throwable ex) {
        return new TryResult<>(false, defaultValue, ex);
    }
    
    public TryResult(boolean isSuccess, TResult resultValue, Throwable exception) {
        this.isSuccess = isSuccess;
        this.resultValue = resultValue;
        this.exception = exception;
    }
    
    public boolean isSuccess() { return isSuccess; }
    public TResult getResultValue() { return resultValue; }
    public Throwable getException() { return exception; }
    public boolean hasException() { return exception != null; }
}
