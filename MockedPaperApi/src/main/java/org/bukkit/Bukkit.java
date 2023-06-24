package org.bukkit;

import org.bukkit.scheduler.BukkitScheduler;

public final class Bukkit {
    private static Server server;
    private static BukkitScheduler scheduler;

    public static Server getServer() {
        return server;
    }

    public static BukkitScheduler getScheduler() {
        return scheduler;
    }

}
