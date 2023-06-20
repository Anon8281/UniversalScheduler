package com.github.Anon8281.universalScheduler;

import com.github.Anon8281.universalScheduler.scheduling.schedulers.BukkitScheduler;
import com.github.Anon8281.universalScheduler.scheduling.schedulers.FoliaScheduler;
import com.github.Anon8281.universalScheduler.scheduling.schedulers.PaperScheduler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.Anon8281.universalScheduler.scheduling.schedulers.TaskScheduler;
import com.github.Anon8281.universalScheduler.utils.JavaUtil;

public class UniversalScheduler extends JavaPlugin {
    public static final boolean isFolia = JavaUtil.classExists("io.papermc.paper.threadedregions.RegionizedServer");
    public static final boolean isExpandedSchedulingAvailable = JavaUtil.classExists("io.papermc.paper.threadedregions.scheduler.ScheduledTask");

    static UniversalScheduler plugin;

    @Override
    public void onEnable() {
        plugin = this;
    }

    public static TaskScheduler getScheduler(Plugin plugin) {
        return isFolia ? new FoliaScheduler(plugin) : (isExpandedSchedulingAvailable ? new PaperScheduler(plugin) : new BukkitScheduler(plugin));
    }

    /**
     * Deprecated: use {@link #getScheduler(Plugin)}
     */
    @Deprecated
    public static TaskScheduler getScheduler() {
        return getScheduler(plugin);
    }
}
