package sevastjan.universalScheduler.utils;

import org.jetbrains.annotations.NotNull;

public class JavaUtil {
    public static boolean classExists(@NotNull String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
