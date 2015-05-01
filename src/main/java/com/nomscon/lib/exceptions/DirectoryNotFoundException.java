/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.exceptions;

public class DirectoryNotFoundException extends RuntimeException {
    private static final String DEFAULT_MESSAGE
        = "Directory could not be found.";

    public DirectoryNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public DirectoryNotFoundException(String message) {
        super(message);
    }
    
    public DirectoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DirectoryNotFoundException(Throwable cause) {
        super(cause);
    }
}
