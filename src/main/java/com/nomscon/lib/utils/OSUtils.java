package com.nomscon.lib.utils;

import com.nomscon.lib.utils.osinfo.*;

public final class OSUtils {
    private final static String osName = System.getProperty("os.name");

    // TODO: add BSD (ex. FreeBSD, NetBSD)
    // TODO: add Android

    private final static boolean isAIX;
    private final static boolean isLinux;
    private final static boolean isMac;
    private final static boolean isSolaris;
    private final static boolean isUnix;
    private final static boolean isWindows;

    private final static IOSInfo osInfoForCurrentEnvironment;

    private OSUtils() { /* cannot be instantiated */ }

    static {
        String lowerCasedName = (osName == null) ? "" : osName.toLowerCase();
        isAIX = lowerCasedName.contains("aix");
        isLinux = lowerCasedName.contains("linux");
        isMac = lowerCasedName.contains("mac");
        isSolaris = lowerCasedName.contains("sunos");
        isUnix = isAIX || isLinux || isSolaris || lowerCasedName.contains("nix");
        isWindows = lowerCasedName.contains("windows");

        if (isMac)
            osInfoForCurrentEnvironment = new MacOSInfo();
        else if (isWindows)
            osInfoForCurrentEnvironment = new WindowsOSInfo();
        else if (isUnix)    // includes AIX, Linux and Solaris
            osInfoForCurrentEnvironment = new UnixBasedOSInfo();
        else
            osInfoForCurrentEnvironment = null;

    }

    public static String getOSName() { return osName; }
    public static boolean isMac() { return isMac; }
    public static boolean isWindows() { return isWindows; }
    public static boolean isLinux() { return isLinux; }

    public final static IOSInfo getOSInfo() { return osInfoForCurrentEnvironment; }
}

