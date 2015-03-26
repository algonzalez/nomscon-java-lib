package com.nomscon.lib.utils.osinfo;

public final class MacOSInfo implements IOSInfo {
    @Override
    public String getAppCacheDir(String appName) {
        return String.format("%s/Library/Caches/%s", getHomeDir(), appName);
    }

    @Override
    public String getAppSupportDir(String appName) {
        return String.format("%s/Library/Application Support/%s", getHomeDir(), appName);
    }
    
    @Override
    public String getDocumentsDir() { return getHomeDir() + "/Documents"; }

    @Override
    public String getHomeDir() { return System.getProperty("user.home"); }
}

// TODO: getPreferencesDir() { return getHomeDir() + "/Library/Preferences"; }