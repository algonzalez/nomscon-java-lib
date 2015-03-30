package com.nomscon.lib.utils;

import com.nomscon.lib.Arg;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class PathUtils {
    
    public static String combine(String firstPath, String... morePaths) {
        Arg.checkIsNotNull(firstPath);
        
        if (morePaths.length == 0) return firstPath;
        
        String resultPath;
        
        if (SysUtils.supportsJava7()) {
            Path combinedPath = Paths.get(firstPath);
            for (String path : morePaths) {
                if (path != null && !path.isEmpty()) {
                    combinedPath = combinedPath.resolve(path);
                }
            }
            resultPath = combinedPath.toString();
        } else {
            File combinedFile = new File(firstPath);
            for (String path : morePaths) {
                if (path != null && !path.isEmpty()) {
                    combinedFile = new File(combinedFile, path);
                }
            }
            resultPath = combinedFile.getParent();
        }
        
        return resultPath;
    }
}
 