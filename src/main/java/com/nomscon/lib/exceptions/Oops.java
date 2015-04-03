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
        public static Exception NotFound(String path) {
            String msg = String.format("The specified directory '%s' could not be found."
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
    }
}
