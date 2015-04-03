/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */

package com.nomscon.lib.validators;

import java.util.Iterator;

/**
 * Describes a type that provides a validator used to
 * check an item of type T.
 * 
 * @param <T> the type of the item to be validated. 
 */
public interface Validator<T> {
    
    /**
     * TODO:
     * 
     * @return the name of the validator.
     */
    String getName();
    
    /**
     * TODO:
     * 
     * @return the description of validator.
     */
    String getDescription();
    
    /**
     * Performs the validation on the specified item.
     * 
     * @param item the thing to validate.
     * @return true if the item passes the validation; otherwise false.
     */
    boolean isValid(T item);
    
    // TODO: create ValidatinError/Exception
    /**
     * Collection of {@link ValidationError}s describing the errors
     * encountered the last time {@link #isValid} was called.
     * 
     * @return an Iterator for the collection of errors 
     */
    Iterator<ValidationError> getErrors();
    // TODO: collection class specific to ValidationErrors
}
