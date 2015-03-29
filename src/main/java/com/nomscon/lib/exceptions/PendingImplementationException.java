package com.nomscon.lib.exceptions;

public class PendingImplementationException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE
        = "Functionality is not yet available, it is pending implementation.";

    public PendingImplementationException() {
        super(DEFAULT_MESSAGE);
    }

    public PendingImplementationException(String message) {
        super(message);
    }
}
