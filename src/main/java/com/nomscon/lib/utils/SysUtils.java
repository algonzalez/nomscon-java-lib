package com.nomscon.lib.utils;

import com.nomscon.lib.Arg;

public final class SysUtils {
    public static Boolean supportsJavaVersion(String desiredVersion) {
        Arg.checkIsNotNullOrWhitespace(desiredVersion);
        Package pkg = System.class.getPackage();
        return pkg.isCompatibleWith(desiredVersion);
    }
    
    public static Boolean supportsJava6() {
        return supportsJavaVersion("1.6");
    }
    
    public static Boolean supportsJava7() {
        return supportsJavaVersion("1.7");
    }
    
    public static Boolean supportsJava8() {
        return supportsJavaVersion("1.8s");
    }
}
