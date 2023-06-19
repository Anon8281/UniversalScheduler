package sevastjan.universalScheduler;

import org.bukkit.plugin.java.JavaPlugin;
import sevastjan.universalScheduler.scheduling.schedulers.FoliaScheduler;
import sevastjan.universalScheduler.scheduling.schedulers.PaperScheduler;
import sevastjan.universalScheduler.scheduling.schedulers.TaskScheduler;
import sevastjan.universalScheduler.utils.JavaUtil;

public class UniversalScheduler extends JavaPlugin {
    private final boolean isFolia = JavaUtil.classExists("io.papermc.paper.threadedregions.RegionizedServer");
    private static TaskScheduler scheduler;
    UniversalScheduler plugin;

    @Override
    public void onEnable() {
        plugin = this;
        scheduler = isFolia ? new FoliaScheduler(plugin) : new PaperScheduler(this);
    }

    public static TaskScheduler getScheduler() {
        return scheduler;
    }
}
