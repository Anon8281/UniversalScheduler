package com.github.Anon8281.universalScheduler;

import com.github.Anon8281.bukkitScheduler.BukkitScheduler;
import com.github.Anon8281.foliaScheduler.FoliaScheduler;
import com.github.Anon8281.paperScheduler.PaperScheduler;
import com.github.Anon8281.universalScheduler.scheduling.schedulers.TaskScheduler;
import com.github.Anon8281.universalScheduler.utils.JavaUtil;
import org.bukkit.plugin.Plugin;

public class UniversalScheduler {
    public static final boolean isFolia = JavaUtil.classExists("io.papermc.paper.threadedregions.RegionizedServer");
    public static final boolean isExpandedSchedulingAvailable = JavaUtil.classExists("io.papermc.paper.threadedregions.scheduler.ScheduledTask");

    public static TaskScheduler getScheduler(Plugin plugin) {
        return isFolia ? new FoliaScheduler(plugin) : (isExpandedSchedulingAvailable ? new PaperScheduler(plugin) : new BukkitScheduler(plugin));
    }

}
