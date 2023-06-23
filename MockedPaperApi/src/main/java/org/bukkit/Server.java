package org.bukkit;

import io.papermc.paper.threadedregions.scheduler.AsyncScheduler;
import io.papermc.paper.threadedregions.scheduler.GlobalRegionScheduler;
import io.papermc.paper.threadedregions.scheduler.RegionScheduler;
import org.bukkit.entity.Entity;

public interface Server {
    RegionScheduler getRegionScheduler();

    GlobalRegionScheduler getGlobalRegionScheduler();

    AsyncScheduler getAsyncScheduler();

    boolean isOwnedByCurrentRegion(Location location);

    boolean isOwnedByCurrentRegion(Entity entity);

    boolean isGlobalTickThread();

    boolean isPrimaryThread();
}
