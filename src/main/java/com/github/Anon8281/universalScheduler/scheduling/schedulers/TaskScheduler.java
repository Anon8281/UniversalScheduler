package com.github.Anon8281.universalScheduler.scheduling.schedulers;

import com.github.Anon8281.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public interface TaskScheduler {

    boolean isGlobalThread();

    boolean isTickThread();

    boolean isEntityThread(Entity entity);

    boolean isRegionThread(Location location);

    @NotNull MyScheduledTask runTask(@NotNull Runnable runnable);

    @NotNull MyScheduledTask runTaskLater(@NotNull Runnable runnable, long delay);

    @NotNull MyScheduledTask runTaskTimer(@NotNull Runnable runnable, long delay, long period);

    /**
     * Deprecated: use {@link #runTask(Runnable)}
     */
    @Deprecated
    default @NotNull MyScheduledTask runTask(JavaPlugin plugin, @NotNull Runnable runnable) {
        return runTask(runnable);
    }

    /**
     * Deprecated: use {@link #runTaskLater(Runnable, long)}
     */
    @Deprecated
    default @NotNull MyScheduledTask runTaskLater(JavaPlugin plugin, @NotNull Runnable runnable, long delay) {
        return runTaskLater(runnable, delay);
    }

    /**
     * Deprecated: use {@link #runTaskTimer(Runnable, long, long)}
     */
    @Deprecated
    default @NotNull MyScheduledTask runTaskTimer(JavaPlugin plugin, @NotNull Runnable runnable, long delay, long period) {
        return runTaskTimer(runnable, delay, period);
    }

    default @NotNull MyScheduledTask runTask(@NotNull Location location, @NotNull Runnable runnable) {
        return runTask(runnable);
    }

    default @NotNull MyScheduledTask runTaskLater(@NotNull Location location, @NotNull Runnable runnable, long delay) {
        return runTaskLater(runnable, delay);
    }

    default @NotNull MyScheduledTask runTaskTimer(@NotNull Location location, @NotNull Runnable runnable, long delay, long period) {
        return runTaskTimer(runnable, delay, period);
    }

    default @NotNull MyScheduledTask runTask(@NotNull Entity entity, @NotNull Runnable runnable) {
        return runTask(runnable);
    }

    default @NotNull MyScheduledTask runTaskLater(@NotNull Entity entity, @NotNull Runnable runnable, long delay) {
        return runTaskLater(runnable, delay);
    }

    default @NotNull MyScheduledTask runTaskTimer(@NotNull Entity entity, @NotNull Runnable runnable, long delay, long period) {
        return runTaskTimer(runnable, delay, period);
    }

    @NotNull MyScheduledTask runTaskAsynchronously(@NotNull Runnable runnable);

    @NotNull MyScheduledTask runTaskLaterAsynchronously(@NotNull Runnable runnable, long delay);

    @NotNull MyScheduledTask runTaskTimerAsynchronously(@NotNull Runnable runnable, long delay, long period);

    /**
     * Deprecated: use {@link #runTaskAsynchronously(Runnable)}
     */
    @Deprecated
    default @NotNull MyScheduledTask runTaskAsynchronously(JavaPlugin plugin, @NotNull Runnable runnable) {
        return runTaskAsynchronously(runnable);
    }

    /**
     * Deprecated: use {@link #runTaskLaterAsynchronously(Runnable, long)}
     */
    @Deprecated
    default @NotNull MyScheduledTask runTaskLaterAsynchronously(JavaPlugin plugin, @NotNull Runnable runnable, long delay) {
        return runTaskLaterAsynchronously(runnable, delay);
    }

    /**
     * Deprecated: use {@link #runTaskTimerAsynchronously(Runnable, long, long)}
     */
    @Deprecated
    default @NotNull MyScheduledTask runTaskTimerAsynchronously(JavaPlugin plugin, @NotNull Runnable runnable, long delay, long period) {
        return runTaskTimerAsynchronously(runnable, delay, period);
    }

    void cancelTasks();

    void cancelTasks(JavaPlugin plugin);
}
