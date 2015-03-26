package com.nomscon.lib.io;

import java.io.File;

public final class IOUtils {
    public final static boolean dirExists(String dirPath) {
        File dir = new File(dirPath);
        return dir.exists() && dir.isDirectory();
    }
    
    public final static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }
}
