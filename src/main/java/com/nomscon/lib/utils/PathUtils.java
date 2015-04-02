package com.nomscon.lib.utils;

import com.nomscon.lib.Arg;
import com.nomscon.lib.TryResult;
import java.io.File;
import java.io.IOException;
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
    
    public static String expandHomeDirTilde(String path) {
        if (path == null || path.isEmpty() || !path.startsWith("~"))
            return path;
        final String userHomeDir = OSUtils.getOSInfo().getHomeDir();
        final String homeDirWithTilde = "~" + File.separator;
        if (path.startsWith(homeDirWithTilde)) {
            return userHomeDir + path.substring(1);
        }
        return userHomeDir 
                + File.separator 
                + ".." 
                + File.separator 
                + path.substring(1);
    }
    
    public TryResult<String> tryGetCanonicalPath(File file, String defaultValue) {
        Arg.checkIsNotNull(file);
        TryResult<String> tryResult;
        try {
            String path = file.getCanonicalPath();
            tryResult = TryResult.asSuccess(path);
        } catch (IOException ex) {
            tryResult = TryResult.asFailure(defaultValue, ex);
        }
        return tryResult;
    }
}
 