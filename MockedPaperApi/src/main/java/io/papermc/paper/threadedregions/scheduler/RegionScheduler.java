package io.papermc.paper.threadedregions.scheduler;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

import java.util.function.Consumer;
public interface RegionScheduler {

    /**
     * Schedules a task to be executed on the region which owns the location.
     *
     * @param plugin The plugin that owns the task
     * @param world  The world of the region that owns the task
     * @param chunkX The chunk X coordinate of the region that owns the task
     * @param chunkZ The chunk Z coordinate of the region that owns the task
     * @param run    The task to execute
     */
    void execute( Plugin plugin,  World world, int chunkX, int chunkZ,  Runnable run);

    /**
     * Schedules a task to be executed on the region which owns the location.
     *
     * @param plugin   The plugin that owns the task
     * @param location The location at which the region executing should own
     * @param run      The task to execute
     */
    default void execute( Plugin plugin,  Location location,  Runnable run) {
        this.execute(plugin, location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4, run);
    }

    /**
     * Schedules a task to be executed on the region which owns the location on the next tick.
     *
     * @param plugin The plugin that owns the task
     * @param world  The world of the region that owns the task
     * @param chunkX The chunk X coordinate of the region that owns the task
     * @param chunkZ The chunk Z coordinate of the region that owns the task
     * @param task   The task to execute
     * @return The {@link ScheduledTask} that represents the scheduled task.
     */
     ScheduledTask run( Plugin plugin,  World world, int chunkX, int chunkZ,  Consumer<ScheduledTask> task);

    /**
     * Schedules a task to be executed on the region which owns the location on the next tick.
     *
     * @param plugin   The plugin that owns the task
     * @param location The location at which the region executing should own
     * @param task     The task to execute
     * @return The {@link ScheduledTask} that represents the scheduled task.
     */
    default  ScheduledTask run( Plugin plugin,  Location location,  Consumer<ScheduledTask> task) {
        return this.run(plugin, location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4, task);
    }

    /**
     * Schedules a task to be executed on the region which owns the location after the specified delay in ticks.
     *
     * @param plugin     The plugin that owns the task
     * @param world      The world of the region that owns the task
     * @param chunkX     The chunk X coordinate of the region that owns the task
     * @param chunkZ     The chunk Z coordinate of the region that owns the task
     * @param task       The task to execute
     * @param delayTicks The delay, in ticks.
     * @return The {@link ScheduledTask} that represents the scheduled task.
     */
     ScheduledTask runDelayed( Plugin plugin,  World world, int chunkX, int chunkZ,  Consumer<ScheduledTask> task,
                                      long delayTicks);

    /**
     * Schedules a task to be executed on the region which owns the location after the specified delay in ticks.
     *
     * @param plugin     The plugin that owns the task
     * @param location   The location at which the region executing should own
     * @param task       The task to execute
     * @param delayTicks The delay, in ticks.
     * @return The {@link ScheduledTask} that represents the scheduled task.
     */
    default  ScheduledTask runDelayed( Plugin plugin,  Location location,  Consumer<ScheduledTask> task,
                                              long delayTicks) {
        return this.runDelayed(plugin, location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4, task, delayTicks);
    }

    /**
     * Schedules a repeating task to be executed on the region which owns the location after the initial delay with the
     * specified period.
     *
     * @param plugin            The plugin that owns the task
     * @param world             The world of the region that owns the task
     * @param chunkX            The chunk X coordinate of the region that owns the task
     * @param chunkZ            The chunk Z coordinate of the region that owns the task
     * @param task              The task to execute
     * @param initialDelayTicks The initial delay, in ticks.
     * @param periodTicks       The period, in ticks.
     * @return The {@link ScheduledTask} that represents the scheduled task.
     */
     ScheduledTask runAtFixedRate( Plugin plugin,  World world, int chunkX, int chunkZ,  Consumer<ScheduledTask> task,
                                          long initialDelayTicks, long periodTicks);

    /**
     * Schedules a repeating task to be executed on the region which owns the location after the initial delay with the
     * specified period.
     *
     * @param plugin            The plugin that owns the task
     * @param location          The location at which the region executing should own
     * @param task              The task to execute
     * @param initialDelayTicks The initial delay, in ticks.
     * @param periodTicks       The period, in ticks.
     * @return The {@link ScheduledTask} that represents the scheduled task.
     */
    default  ScheduledTask runAtFixedRate( Plugin plugin,  Location location,  Consumer<ScheduledTask> task,
                                                  long initialDelayTicks, long periodTicks) {
        return this.runAtFixedRate(plugin, location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4, task, initialDelayTicks, periodTicks);
    }
}
