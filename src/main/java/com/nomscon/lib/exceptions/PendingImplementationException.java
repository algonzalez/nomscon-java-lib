/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.exceptions;

public class PendingImplementationException extends RuntimeException {
    private static final String DEFAULT_MESSAGE
        = "Functionality is not yet available, it is pending implementation.";

    public PendingImplementationException() {
        super(DEFAULT_MESSAGE);
    }

    public PendingImplementationException(String message) {
        super(message);
    }

    public PendingImplementationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public PendingImplementationException(Throwable cause) {
        super(cause);
    }
}
