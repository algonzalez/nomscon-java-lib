package com.nomscon.lib.utils.osinfo;

public class UnixBasedOSInfo implements IOSInfo {
    @Override
    public String getAppCacheDir(String appName) {
        return String.format("%s/.cache/%s", getHomeDir(), appName.toLowerCase());
    }
    
    @Override
    public String getAppSupportDir(String appName) {
        return String.format("%s/.%s", getHomeDir(), appName.toLowerCase());
    }

    // TODO: find what is common for this
    @Override
    public String getDocumentsDir() { return getHomeDir() + "/Documents"; }

    @Override
    public String getHomeDir() { return System.getProperty("user.home"); }
}
