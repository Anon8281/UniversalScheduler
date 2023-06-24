package com.github.Anon8281.foliaScheduler;

import com.github.Anon8281.scheduling.schedulers.TaskScheduler;
import com.github.Anon8281.scheduling.tasks.MyScheduledTask;
import io.papermc.paper.threadedregions.scheduler.AsyncScheduler;
import io.papermc.paper.threadedregions.scheduler.GlobalRegionScheduler;
import io.papermc.paper.threadedregions.scheduler.RegionScheduler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.TimeUnit;
public class FoliaScheduler implements TaskScheduler {

    final Plugin plugin;

    public FoliaScheduler(Plugin plugin) {
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
    public boolean isEntityThread( Entity entity) {
        return Bukkit.getServer().isOwnedByCurrentRegion(entity);
    }

    @Override
    public boolean isRegionThread( Location location) {
        return Bukkit.getServer().isOwnedByCurrentRegion(location);
    }

    @Override
    public  MyScheduledTask runTask( Runnable runnable) {
        return new FoliaScheduledTask(globalRegionScheduler.run(plugin, task -> runnable.run()));
    }

    @Override
    public  MyScheduledTask runTaskLater( Runnable runnable, long delay) {
        return new FoliaScheduledTask(globalRegionScheduler.runDelayed(plugin, task -> runnable.run(), delay));
    }

    @Override
    public  MyScheduledTask runTaskTimer( Runnable runnable, long delay, long period) {
        return new FoliaScheduledTask(globalRegionScheduler.runAtFixedRate(plugin, task -> runnable.run(), delay, period));
    }

    @Override
    public  MyScheduledTask runTask(Plugin plugin,  Runnable runnable) {
        return new FoliaScheduledTask(globalRegionScheduler.run(plugin, task -> runnable.run()));
    }

    @Override
    public  MyScheduledTask runTaskLater(Plugin plugin,  Runnable runnable, long delay) {
        return new FoliaScheduledTask(globalRegionScheduler.runDelayed(plugin, task -> runnable.run(), delay));
    }

    @Override
    public  MyScheduledTask runTaskTimer(Plugin plugin,  Runnable runnable, long delay, long period) {
        return new FoliaScheduledTask(globalRegionScheduler.runAtFixedRate(plugin, task -> runnable.run(), delay, period));
    }

    @Override
    public  MyScheduledTask runTask( Location location,  Runnable runnable) {
        return new FoliaScheduledTask(regionScheduler.run(plugin, location, task -> runnable.run()));
    }

    @Override
    public  MyScheduledTask runTaskLater( Location location,  Runnable runnable, long delay) {
        return new FoliaScheduledTask(regionScheduler.runDelayed(plugin, location, task -> runnable.run(), delay));
    }

    @Override
    public  MyScheduledTask runTaskTimer( Location location,  Runnable runnable, long delay, long period) {
        return new FoliaScheduledTask(regionScheduler.runAtFixedRate(plugin, location, task -> runnable.run(), delay, period));
    }

    @Override
    public  MyScheduledTask runTask( Entity entity,  Runnable runnable) {
        return new FoliaScheduledTask(regionScheduler.run(plugin, entity.getLocation(), task -> runnable.run()));
    }

    @Override
    public  MyScheduledTask runTaskLater( Entity entity,  Runnable runnable, long delay) {
        return new FoliaScheduledTask(regionScheduler.runDelayed(plugin, entity.getLocation(), task -> runnable.run(), delay));
    }

    @Override
    public  MyScheduledTask runTaskTimer( Entity entity,  Runnable runnable, long delay, long period) {
        return new FoliaScheduledTask(regionScheduler.runAtFixedRate(plugin, entity.getLocation(), task -> runnable.run(), delay, period));
    }

    @Override
    public  MyScheduledTask runTaskAsynchronously( Runnable runnable) {
        return new FoliaScheduledTask(asyncScheduler.runNow(plugin, task -> runnable.run()));
    }

    @Override
    public  MyScheduledTask runTaskLaterAsynchronously( Runnable runnable, long delay) {
        return new FoliaScheduledTask(asyncScheduler.runDelayed(plugin, task -> runnable.run(), delay * 50L, TimeUnit.MILLISECONDS));
    }

    @Override
    public  MyScheduledTask runTaskTimerAsynchronously( Runnable runnable, long delay, long period) {
        return new FoliaScheduledTask(asyncScheduler.runAtFixedRate(plugin, task -> runnable.run(), delay * 50, period * 50, TimeUnit.MILLISECONDS));
    }

    @Override
    public  MyScheduledTask runTaskAsynchronously(Plugin plugin,  Runnable runnable) {
        return new FoliaScheduledTask(asyncScheduler.runNow(plugin, task -> runnable.run()));
    }

    @Override
    public  MyScheduledTask runTaskLaterAsynchronously(Plugin plugin,  Runnable runnable, long delay) {
        return new FoliaScheduledTask(asyncScheduler.runDelayed(plugin, task -> runnable.run(), delay * 50L, TimeUnit.MILLISECONDS));
    }

    @Override
    public  MyScheduledTask runTaskTimerAsynchronously(Plugin plugin,  Runnable runnable, long delay, long period) {
        return new FoliaScheduledTask(asyncScheduler.runAtFixedRate(plugin, task -> runnable.run(), delay * 50, period * 50, TimeUnit.MILLISECONDS));
    }

    @Override
    public void cancelTasks() {
        globalRegionScheduler.cancelTasks(plugin);
        asyncScheduler.cancelTasks(plugin);
    }

    @Override
    public void cancelTasks(Plugin plugin) {
        globalRegionScheduler.cancelTasks(plugin);
        asyncScheduler.cancelTasks(plugin);
    }

}
