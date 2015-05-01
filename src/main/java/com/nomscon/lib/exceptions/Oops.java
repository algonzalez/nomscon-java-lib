/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.exceptions;

/**
 * Provides methods that return an appropriate {@code Exception} instance
 * that is created with a default error message.
 */
public final class Oops {
    
    /**
     * Provides methods that return an {@code Exception} instance
     * that pertains specifically to dealing with directories.
     */
    public static class Directory {
        
        /**
         * Returns a {@link DirectoryNotFoundException} instance
         * for when a directory does not exist.
         * 
         * @param path the path to the missing directory.
         * @return a DirectoryNotFoundException instance.
         */
        public static RuntimeException NotFound(String path) {
            final String msg = String.format("The specified directory '%s' could not be found."
                    , path);
            return new DirectoryNotFoundException(msg);
        }
    }
    
    /**
     * Provides methods that return an {@code Exception} instance
     * that pertains specifically to dealing with method arguments.
     */
    public static class Argument {
        // TODO:
        
        /**
         * Returns an appropriate exception for when a required argument is passed
         * as empty or composed only of whitespace characters.
         * 
         * @return an IllegalArgumentException instance.
         */
        public static RuntimeException IsEmptyOrWhiteSpace() {
            final String msg = "Value cannot empty or composed of only whitespace characters.";
            return new IllegalArgumentException(msg);
        }

        /**
         * Returns an appropriate exception for when 
         * a non-zero argument is passed as a negative.
         * 
         * @return an IllegalArgumentException instance.
         */
        public static RuntimeException IsNegative() {
            String msg = "Value cannot be less than zero.";
            return new IllegalArgumentException(msg);
        }
        
        /**
         * Returns an appropriate exception for when an argument 
         * is not within a specific range.
         * 
         * @param argValue The actual value that was passed.
         * @param minValue The minimum value allowed.
         * @param maxValue The maximum value allowed.
         * @return a ValueNotInRangeException instance.
         */
        public static RuntimeException IsNotInRange(int argValue, int minValue, int maxValue) {
            return new ValueNotInRangeException(argValue, minValue, maxValue);
        }

        /**
         * Returns an appropriate exception for when 
         * a required argument is not specified.
         * 
         * @param paramName The name of the parameter that caused the exception.
         * @return an IllegalArgumentException instance.
         */
        public static RuntimeException IsNotSpecified(String paramName) {
            String msg = String.format("A value for the '%s' must be specified.", paramName);
            return new IllegalArgumentException(msg);
        }

        /**
         * Returns an appropriate exception for when 
         * an argument value is not valid.
         * 
         * @param message The message explaining the error.
         * @return an IllegalArgumentException instance.
         */
        public static RuntimeException IsNotValid(String message) {
            return new IllegalArgumentException(message);
        }
        
        /**
         * Returns an appropriate exception for when 
         * a required argument is passed as null.
         * 
         * @param message The message explaining the error.
         * @return an NullPointerException instance.
         */
        public static RuntimeException IsNull(String message) {
            return new NullPointerException(message);
        }
        
        /**
         * Returns an appropriate exception for when an argument 
         * of an unexpected Type is passed in.
         * 
         * @param paramName The name of the parameter that caused the exception.
         * @param expectedType The expected type of the parameter.
         * @return an IllegalArgumentException instance.
         */
        public static RuntimeException IsWrongType(String paramName, Class expectedType) {
            String msg = String.format("'%s' is not a subclass of '%s'."
                    , paramName, expectedType.getSimpleName());
            return new IllegalArgumentException(msg);
        }
    }
    
    /**
     * Returns an appropriate exception for when a method call
     * is not valid for the object's current state.
     * 
     * @param message The message explaining the error.
     * @return an IllegalStateException instance
     */
    public static RuntimeException ObjectStateIsInvalid(String message) {
        return new IllegalStateException(message);
    }
}
