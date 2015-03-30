package com.nomscon.lib.utils;

import java.io.File;

public class DirUtils {

    final static int MAX_CREATE_TEMP_DIR_ATTEMPTS = 999;
    
    public static File createTempDir(String prefix) {
        File baseTempDir = getTempDir();
        
        String newDirName = ((prefix == null || prefix.isEmpty())
                ? ""
                : prefix + System.currentTimeMillis() + "-temp");
        
        for (int i = 0; i < MAX_CREATE_TEMP_DIR_ATTEMPTS; i++) {
            File newTempDir = new File(baseTempDir, newDirName);
            if (newTempDir.mkdir()) return newTempDir;
        }
        throw new IllegalStateException("createTempDir failed after "
            + MAX_CREATE_TEMP_DIR_ATTEMPTS + " attempts.");
    }
    
    public static File getTempDir() {
        return new File(getTempDirPath());
    }
    
    public static String getTempDirPath() {
        return System.getProperty("java.io.tmpdir");
    }
}
