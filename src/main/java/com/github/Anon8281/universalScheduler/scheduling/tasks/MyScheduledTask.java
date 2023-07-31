package com.github.Anon8281.universalScheduler.scheduling.tasks;

import org.bukkit.plugin.Plugin;

public interface MyScheduledTask {
    /**
     * Cancels executing task
     */
    void cancel();

    /**
     * @return true if task is cancelled, false otherwise
     */
    boolean isCancelled();

    /**
     * @return The plugin under which the task was scheduled.
     */
    Plugin getOwningPlugin();

    /**
     * @return true if task is currently executing, false otherwise
     */
    boolean isCurrentlyRunning();

    /**
     * @return true if task is repeating, false otherwise
     */
    boolean isRepeatingTask();

    /**
     * Gets the task id for this runnable.<br>
     * Doesn't support Folia due to Folia don't have this method.
     * @return the task id that this runnable was scheduled as
     * @throws UnsupportedOperationException if invoked on Folia. Use {@link com.github.Anon8281.universalScheduler.UniversalScheduler#isFolia}.
     */
    int getTaskId();
}