package sevastjan.universalScheduler;

import org.bukkit.plugin.java.JavaPlugin;
import sevastjan.universalScheduler.scheduling.schedulers.FoliaScheduler;
import sevastjan.universalScheduler.scheduling.schedulers.PaperScheduler;
import sevastjan.universalScheduler.scheduling.schedulers.TaskScheduler;
import sevastjan.universalScheduler.utils.JavaUtil;

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

    @Deprecated
    public static TaskScheduler getScheduler() {
        return getScheduler(plugin);
    }
}
