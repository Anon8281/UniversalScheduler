package org.bukkit.scheduler;

import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public interface BukkitScheduler {
    int scheduleSyncDelayedTask(Plugin var1, Runnable var2, long var3);

    /**
     * @deprecated
     */
    @Deprecated
    int scheduleSyncDelayedTask(Plugin var1, BukkitRunnable var2, long var3);

    int scheduleSyncDelayedTask(Plugin var1, Runnable var2);

    /**
     * @deprecated
     */
    @Deprecated
    int scheduleSyncDelayedTask(Plugin var1, BukkitRunnable var2);

    int scheduleSyncRepeatingTask(Plugin var1, Runnable var2, long var3, long var5);

    /**
     * @deprecated
     */
    @Deprecated
    int scheduleSyncRepeatingTask(Plugin var1, BukkitRunnable var2, long var3, long var5);

    /**
     * @deprecated
     */
    @Deprecated
    int scheduleAsyncDelayedTask(Plugin var1, Runnable var2, long var3);

    /**
     * @deprecated
     */
    @Deprecated
    int scheduleAsyncDelayedTask(Plugin var1, Runnable var2);

    /**
     * @deprecated
     */
    @Deprecated
    int scheduleAsyncRepeatingTask(Plugin var1, Runnable var2, long var3, long var5);


    <T> Future<T> callSyncMethod(Plugin var1, Callable<T> var2);

    void cancelTask(int var1);

    void cancelTasks(Plugin var1);

    boolean isCurrentlyRunning(int var1);

    boolean isQueued(int var1);

    List<BukkitTask> getPendingTasks();


    BukkitTask runTask(Plugin var1, Runnable var2) throws IllegalArgumentException;

    void runTask(Plugin var1, Consumer<BukkitTask> var2) throws IllegalArgumentException;

    /**
     * @deprecated
     */
    @Deprecated
    BukkitTask runTask(Plugin var1, BukkitRunnable var2) throws IllegalArgumentException;


    BukkitTask runTaskAsynchronously(Plugin var1, Runnable var2) throws IllegalArgumentException;

    void runTaskAsynchronously(Plugin var1, Consumer<BukkitTask> var2) throws IllegalArgumentException;

    /**
     * @deprecated
     */
    @Deprecated
    BukkitTask runTaskAsynchronously(Plugin var1, BukkitRunnable var2) throws IllegalArgumentException;


    BukkitTask runTaskLater(Plugin var1, Runnable var2, long var3) throws IllegalArgumentException;

    void runTaskLater(Plugin var1, Consumer<BukkitTask> var2, long var3) throws IllegalArgumentException;

    /**
     * @deprecated
     */
    @Deprecated
    BukkitTask runTaskLater(Plugin var1, BukkitRunnable var2, long var3) throws IllegalArgumentException;


    BukkitTask runTaskLaterAsynchronously(Plugin var1, Runnable var2, long var3) throws IllegalArgumentException;

    void runTaskLaterAsynchronously(Plugin var1, Consumer<BukkitTask> var2, long var3) throws IllegalArgumentException;

    /**
     * @deprecated
     */
    @Deprecated
    BukkitTask runTaskLaterAsynchronously(Plugin var1, BukkitRunnable var2, long var3) throws IllegalArgumentException;


    BukkitTask runTaskTimer(Plugin var1, Runnable var2, long var3, long var5) throws IllegalArgumentException;

    void runTaskTimer(Plugin var1, Consumer<BukkitTask> var2, long var3, long var5) throws IllegalArgumentException;

    /**
     * @deprecated
     */
    @Deprecated
    BukkitTask runTaskTimer(Plugin var1, BukkitRunnable var2, long var3, long var5) throws IllegalArgumentException;


    BukkitTask runTaskTimerAsynchronously(Plugin var1, Runnable var2, long var3, long var5) throws IllegalArgumentException;

    void runTaskTimerAsynchronously(Plugin var1, Consumer<BukkitTask> var2, long var3, long var5) throws IllegalArgumentException;

    /**
     * @deprecated
     */
    @Deprecated
    BukkitTask runTaskTimerAsynchronously(Plugin var1, BukkitRunnable var2, long var3, long var5) throws IllegalArgumentException;
}
