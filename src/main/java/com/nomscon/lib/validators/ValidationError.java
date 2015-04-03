/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */

package com.nomscon.lib.validators;

/**
 * Represents an error encountered when making an {@link Validator#isValid} call.
 */
public final class ValidationError {
    
    /**
     * Initializes a new instance of the {@link ValidationError} class.
     * 
     * @param errCode the code/id associated with the error.
     * @param errMessage the description of the error.
     */
    public ValidationError(int errCode, String errMessage) {
        this.code = errCode;
        this.message = errMessage;
    }
    
    /**
     * the code/id associated with the error.
     */
    public final int code;
    
    /**
     * The description of the error.
     */
    public final String message;
}
