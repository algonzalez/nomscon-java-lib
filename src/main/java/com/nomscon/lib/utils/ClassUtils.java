package com.nomscon.lib.utils;

public final class ClassUtils {
    public boolean isPresent(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (Throwable ex) {
            // specified Class, or one of its dependencies, was not found
            return false;
        }
    }
}


