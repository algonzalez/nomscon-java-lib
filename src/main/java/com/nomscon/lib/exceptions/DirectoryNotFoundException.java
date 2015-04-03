package com.nomscon.lib.exceptions;

public class DirectoryNotFoundException extends Exception {
    private static final String DEFAULT_MESSAGE
        = "Directory could not be found.";

    public DirectoryNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public DirectoryNotFoundException(String message) {
        super(message);
    }
}
