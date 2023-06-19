package com.github.Anon8281.universalScheduler;

import com.github.Anon8281.universalScheduler.scheduling.schedulers.FoliaScheduler;
import com.github.Anon8281.universalScheduler.scheduling.schedulers.PaperScheduler;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.Anon8281.universalScheduler.scheduling.schedulers.TaskScheduler;
import com.github.Anon8281.universalScheduler.utils.JavaUtil;

public class UniversalScheduler extends JavaPlugin {
    private static final boolean isFolia = JavaUtil.classExists("io.papermc.paper.threadedregions.RegionizedServer");
    static UniversalScheduler plugin;

    @Override
    public void onEnable() {
        plugin = this;
    }

    public static TaskScheduler getScheduler(JavaPlugin plugin) {
        return isFolia ? new FoliaScheduler(plugin) : new PaperScheduler(plugin);
    }

    /**
     * Deprecated: use {@link #getScheduler(JavaPlugin)}
     */
    @Deprecated
    public static TaskScheduler getScheduler() {
        return getScheduler(plugin);
    }
}
