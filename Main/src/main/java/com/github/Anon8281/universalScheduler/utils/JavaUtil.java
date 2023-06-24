package com.github.Anon8281.universalScheduler.utils;

public class JavaUtil {
    public static boolean classExists( String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
