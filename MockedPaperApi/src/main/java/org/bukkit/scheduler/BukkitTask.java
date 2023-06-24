package org.bukkit.scheduler;

import org.bukkit.plugin.Plugin;

public interface BukkitTask {
    Plugin getOwner();
    boolean isCancelled();
    void cancel();
    int getTaskId();

}
