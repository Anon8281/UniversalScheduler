package com.github.Anon8281.universalScheduler.scheduling.schedulers;

import com.github.Anon8281.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface TaskScheduler {

    /**
     * Paper: returns {@link org.bukkit.Server#isPrimaryThread} <br>
     * Bukkit: returns {@link org.bukkit.Server#isPrimaryThread}
     */
    boolean isGlobalThread();

    /**
     * Bukkit: returns {@link org.bukkit.Server#isPrimaryThread}
     */
    boolean isTickThread();

    /**
     * Bukkit: returns {@link org.bukkit.Server#isPrimaryThread}
     */
    boolean isEntityThread(Entity entity);

    /**
     * Bukkit: returns {@link org.bukkit.Server#isPrimaryThread}
     */
    boolean isRegionThread(Location location);

    MyScheduledTask runTask(Runnable runnable);

    MyScheduledTask runTaskLater(Runnable runnable, long delay);

    MyScheduledTask runTaskTimer(Runnable runnable, long delay, long period);

    /**
     * Deprecated: use {@link #runTask(Runnable)}
     */
    @Deprecated
    default MyScheduledTask runTask(Plugin plugin, Runnable runnable) {
        return runTask(runnable);
    }

    /**
     * Deprecated: use {@link #runTaskLater(Runnable, long)}
     */
    @Deprecated
    default MyScheduledTask runTaskLater(Plugin plugin, Runnable runnable, long delay) {
        return runTaskLater(runnable, delay);
    }

    /**
     * Deprecated: use {@link #runTaskTimer(Runnable, long, long)}
     */
    @Deprecated
    default MyScheduledTask runTaskTimer(Plugin plugin, Runnable runnable, long delay, long period) {
        return runTaskTimer(runnable, delay, period);
    }

    default MyScheduledTask runTask(Location location, Runnable runnable) {
        return runTask(runnable);
    }

    default MyScheduledTask runTaskLater(Location location, Runnable runnable, long delay) {
        return runTaskLater(runnable, delay);
    }

    @Deprecated
    default MyScheduledTask scheduleSyncDelayedTask(Runnable runnable, long delay) {
        return runTaskLater(runnable, delay);
    }

    @Deprecated
    default MyScheduledTask scheduleSyncDelayedTask(Runnable runnable) {
        return runTask(runnable);
    }

    default MyScheduledTask runTaskTimer(Location location, Runnable runnable, long delay, long period) {
        return runTaskTimer(runnable, delay, period);
    }

    default MyScheduledTask scheduleSyncRepeatingTask(Runnable runnable, long delay, long period) {
        return runTaskTimer(runnable, delay, period);
    }

    default MyScheduledTask runTask(Entity entity, Runnable runnable) {
        return runTask(runnable);
    }

    default MyScheduledTask runTaskLater(Entity entity, Runnable runnable, long delay) {
        return runTaskLater(runnable, delay);
    }

    default MyScheduledTask runTaskTimer(Entity entity, Runnable runnable, long delay, long period) {
        return runTaskTimer(runnable, delay, period);
    }

    MyScheduledTask runTaskAsynchronously(Runnable runnable);

    MyScheduledTask runTaskLaterAsynchronously(Runnable runnable, long delay);

    MyScheduledTask runTaskTimerAsynchronously(Runnable runnable, long delay, long period);

    /**
     * Deprecated: use {@link #runTaskAsynchronously(Runnable)}
     */
    @Deprecated
    default MyScheduledTask runTaskAsynchronously(Plugin plugin, Runnable runnable) {
        return runTaskAsynchronously(runnable);
    }

    /**
     * Deprecated: use {@link #runTaskLaterAsynchronously(Runnable, long)}
     */
    @Deprecated
    default MyScheduledTask runTaskLaterAsynchronously(Plugin plugin, Runnable runnable, long delay) {
        return runTaskLaterAsynchronously(runnable, delay);
    }

    /**
     * Deprecated: use {@link #runTaskTimerAsynchronously(Runnable, long, long)}
     */
    @Deprecated
    default MyScheduledTask runTaskTimerAsynchronously(Plugin plugin, Runnable runnable, long delay, long period) {
        return runTaskTimerAsynchronously(runnable, delay, period);
    }

    /**
     * Deprecated: magic method
     */
    @Deprecated
    default <T> Future<T> callSyncMethod(final Callable<T> task) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        runTask(() -> {
            try {
                completableFuture.complete(task.call());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return completableFuture;
    }

    void cancelTasks();

    void cancelTasks(Plugin plugin);
}
