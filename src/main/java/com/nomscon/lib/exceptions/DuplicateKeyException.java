/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.exceptions;

public class DuplicateKeyException extends RuntimeException {
    private static final String DEFAULT_MESSAGE_TEMPLATE
        = "The specified key name, '%s', already exists.";
    
    private final String keyName;

    public DuplicateKeyException() {
        super();
        this.keyName = null;
    }

    public DuplicateKeyException(String keyName) {
        this(keyName, String.format(DEFAULT_MESSAGE_TEMPLATE, keyName));
    }

    public DuplicateKeyException(String keyName, String message) {
        super(message);
        this.keyName = keyName;
    }
    
    public DuplicateKeyException(String keyName, String message, Throwable cause) {
        super(message, cause);
        this.keyName = keyName;
    }
    
    public DuplicateKeyException(Throwable cause) {
        super(cause);
        this.keyName = null;
    }
}
