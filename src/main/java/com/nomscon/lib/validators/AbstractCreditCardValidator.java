/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */

package com.nomscon.lib.validators;

public abstract class AbstractCreditCardValidator extends AbstractValidator<String> {
    public AbstractCreditCardValidator() {
        setDescription("Checks that a credit card number is valid for the issuer.");
    }
}
