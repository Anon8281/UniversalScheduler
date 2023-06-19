package sevastjan.universalScheduler.scheduling.schedulers;

import io.papermc.paper.threadedregions.scheduler.AsyncScheduler;
import io.papermc.paper.threadedregions.scheduler.GlobalRegionScheduler;
import io.papermc.paper.threadedregions.scheduler.RegionScheduler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import sevastjan.universalScheduler.UniversalScheduler;
import sevastjan.universalScheduler.scheduling.tasks.FoliaScheduledTask;
import sevastjan.universalScheduler.scheduling.tasks.MyScheduledTask;

import java.util.concurrent.TimeUnit;

public class FoliaScheduler implements TaskScheduler {

    final UniversalScheduler plugin;

    public FoliaScheduler(UniversalScheduler plugin) {
        this.plugin = plugin;
    }

    private final RegionScheduler regionScheduler = Bukkit.getServer().getRegionScheduler();
    private final GlobalRegionScheduler globalRegionScheduler = Bukkit.getServer().getGlobalRegionScheduler();
    private final AsyncScheduler asyncScheduler = Bukkit.getServer().getAsyncScheduler();

    @Override
    public boolean isGlobalThread() {
        return Bukkit.getServer().isGlobalTickThread();
    }

    @Override
    public boolean isTickThread() {
        return Bukkit.getServer().isPrimaryThread(); // The Paper implementation checks whether this is a tick thread, this method exists to avoid confusion.
    }

    @Override
    public boolean isEntityThread(@NotNull Entity entity) {
        return Bukkit.getServer().isOwnedByCurrentRegion(entity);
    }

    @Override
    public boolean isRegionThread(@NotNull Location location) {
        return Bukkit.getServer().isOwnedByCurrentRegion(location);
    }

    @Override
    public @NotNull MyScheduledTask runTask(@NotNull Runnable runnable) {
        return new FoliaScheduledTask(globalRegionScheduler.run(plugin, task -> runnable.run()));
    }

    @Override
    public @NotNull MyScheduledTask runTaskLater(@NotNull Runnable runnable, long delay) {
        return new FoliaScheduledTask(globalRegionScheduler.runDelayed(plugin, task -> runnable.run(), delay));
    }

    @Override
    public @NotNull MyScheduledTask runTaskTimer(@NotNull Runnable runnable, long delay, long period) {
        return new FoliaScheduledTask(globalRegionScheduler.runAtFixedRate(plugin, task -> runnable.run(), delay, period));
    }

    @Override
    public @NotNull MyScheduledTask runTask(@NotNull Location location, @NotNull Runnable runnable) {
        return new FoliaScheduledTask(regionScheduler.run(plugin, location, task -> runnable.run()));
    }

    @Override
    public @NotNull MyScheduledTask runTaskLater(@NotNull Location location, @NotNull Runnable runnable, long delay) {
        return new FoliaScheduledTask(regionScheduler.runDelayed(plugin, location, task -> runnable.run(), delay));
    }

    @Override
    public @NotNull MyScheduledTask runTaskTimer(@NotNull Location location, @NotNull Runnable runnable, long delay, long period) {
        return new FoliaScheduledTask(regionScheduler.runAtFixedRate(plugin, location, task -> runnable.run(), delay, period));
    }

    @Override
    public @NotNull MyScheduledTask runTask(@NotNull Entity entity, @NotNull Runnable runnable) {
        return new FoliaScheduledTask(regionScheduler.run(plugin, entity.getLocation(), task -> runnable.run()));
    }

    @Override
    public @NotNull MyScheduledTask runTaskLater(@NotNull Entity entity, @NotNull Runnable runnable, long delay) {
        return new FoliaScheduledTask(regionScheduler.runDelayed(plugin, entity.getLocation(), task -> runnable.run(), delay));
    }

    @Override
    public @NotNull MyScheduledTask runTaskTimer(@NotNull Entity entity, @NotNull Runnable runnable, long delay, long period) {
        return new FoliaScheduledTask(regionScheduler.runAtFixedRate(plugin, entity.getLocation(), task -> runnable.run(), delay, period));
    }

    @Override
    public @NotNull MyScheduledTask runTaskAsynchronously(@NotNull Runnable runnable) {
        return new FoliaScheduledTask(asyncScheduler.runNow(plugin, task -> runnable.run()));
    }

    @Override
    public @NotNull MyScheduledTask runTaskLaterAsynchronously(@NotNull Runnable runnable, long delay) {
        return new FoliaScheduledTask(asyncScheduler.runDelayed(plugin, task -> runnable.run(), delay * 50L, TimeUnit.MILLISECONDS));
    }

    @Override
    public @NotNull MyScheduledTask runTaskTimerAsynchronously(@NotNull Runnable runnable, long delay, long period) {
        return new FoliaScheduledTask(asyncScheduler.runAtFixedRate(plugin, task -> runnable.run(), delay * 50, period * 50, TimeUnit.MILLISECONDS));
    }

    @Override
    public void cancelTasks() {
        globalRegionScheduler.cancelTasks(plugin);
        asyncScheduler.cancelTasks(plugin);
    }

}
