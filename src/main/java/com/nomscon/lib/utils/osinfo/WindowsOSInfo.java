package com.nomscon.lib.utils.osinfo;

public final class WindowsOSInfo implements IOSInfo {
    @Override
    public String getAppCacheDir(String appName) {
        return getAppSupportDir(appName) + "\\Cache";
    }

    @Override
    public String getAppSupportDir(String appName) { 
        return String.format("%s\\AppData\\Local\\%s", getHomeDir(), appName);
    }
    
    @Override
    public String getDocumentsDir() { return getHomeDir() + "\\Documents"; }

    @Override
    public String getHomeDir() { return System.getProperty("user.home"); }
}
