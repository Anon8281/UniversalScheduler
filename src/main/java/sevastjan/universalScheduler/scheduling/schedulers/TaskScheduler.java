package sevastjan.universalScheduler.scheduling.schedulers;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import sevastjan.universalScheduler.scheduling.tasks.MyScheduledTask;

public interface TaskScheduler {

    boolean isGlobalThread();

    boolean isTickThread();

    boolean isEntityThread(Entity entity);

    boolean isRegionThread(Location location);

    @NotNull MyScheduledTask runTask(@NotNull Runnable runnable);

    @NotNull MyScheduledTask runTaskLater(@NotNull Runnable runnable, long delay);

    @NotNull MyScheduledTask runTaskTimer(@NotNull Runnable runnable, long delay, long period);

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

    void cancelTasks();
}
