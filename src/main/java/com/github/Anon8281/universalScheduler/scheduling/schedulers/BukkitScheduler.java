package com.github.Anon8281.universalScheduler.scheduling.schedulers;

import com.github.Anon8281.universalScheduler.scheduling.tasks.BukkitScheduledTask;
import com.github.Anon8281.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class BukkitScheduler implements TaskScheduler {
    final Plugin plugin;

    public BukkitScheduler(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean isGlobalThread() {
        return Bukkit.getServer().isPrimaryThread();
    }

    @Override
    public boolean isTickThread() {
        return Bukkit.getServer().isPrimaryThread();
    }

    @Override
    public boolean isEntityThread(@NotNull Entity entity) {
        return Bukkit.getServer().isPrimaryThread();
    }

    @Override
    public boolean isRegionThread(@NotNull Location location) {
        return Bukkit.getServer().isPrimaryThread();
    }

    @Override
    public @NotNull MyScheduledTask runTask(@NotNull Runnable runnable) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTask(plugin, runnable));
    }

    @Override
    public @NotNull MyScheduledTask runTaskLater(@NotNull Runnable runnable, long delay) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskLater(plugin, runnable, delay));
    }

    @Override
    public @NotNull MyScheduledTask runTaskTimer(@NotNull Runnable runnable, long delay, long period) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskTimer(plugin, runnable, delay, period));
    }

    @Override
    public @NotNull MyScheduledTask runTaskAsynchronously(@NotNull Runnable runnable) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable));
    }

    @Override
    public @NotNull MyScheduledTask runTaskLaterAsynchronously(@NotNull Runnable runnable, long delay) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, runnable, delay));
    }

    @Override
    public @NotNull MyScheduledTask runTaskTimerAsynchronously(@NotNull Runnable runnable, long delay, long period) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, runnable, delay, period));
    }

    //Useless? Or...
    public @NotNull MyScheduledTask runTask(Plugin plugin, @NotNull Runnable runnable) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTask(plugin, runnable));
    }

    @Override
    public @NotNull MyScheduledTask runTaskLater(Plugin plugin, @NotNull Runnable runnable, long delay) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskLater(plugin, runnable, delay));
    }

    @Override
    public @NotNull MyScheduledTask runTaskTimer(Plugin plugin, @NotNull Runnable runnable, long delay, long period) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskTimer(plugin, runnable, delay, period));
    }

    @Override
    public @NotNull MyScheduledTask runTaskAsynchronously(Plugin plugin, @NotNull Runnable runnable) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable));
    }

    @Override
    public @NotNull MyScheduledTask runTaskLaterAsynchronously(Plugin plugin, @NotNull Runnable runnable, long delay) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, runnable, delay));
    }

    @Override
    public @NotNull MyScheduledTask runTaskTimerAsynchronously(Plugin plugin, @NotNull Runnable runnable, long delay, long period) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, runnable, delay, period));
    }

    @Override
    public void cancelTasks() {
        Bukkit.getScheduler().cancelTasks(plugin);
    }

    @Override
    public void cancelTasks(Plugin plugin) {
        Bukkit.getScheduler().cancelTasks(plugin);
    }
}
