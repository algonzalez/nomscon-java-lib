package com.nomscon.lib.utils.osinfo;

public interface IOSInfo {
    String getAppCacheDir(String appName);
    String getAppSupportDir(String appName);
    String getDocumentsDir();
    String getHomeDir();
}
