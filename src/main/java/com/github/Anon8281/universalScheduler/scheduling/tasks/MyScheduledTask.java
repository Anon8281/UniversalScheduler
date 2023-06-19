package com.github.Anon8281.universalScheduler.scheduling.tasks;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface MyScheduledTask {
    void cancel();

    boolean isCancelled();

    @NotNull Plugin getOwningPlugin();

    boolean isCurrentlyRunning();

    boolean isRepeatingTask();
}