package sevastjan.universalScheduler.scheduling.tasks;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;
import sevastjan.universalScheduler.UniversalScheduler;

import javax.inject.Inject;

public class PaperScheduledTask implements MyScheduledTask {

    @Inject
    UniversalScheduler plugin;

    BukkitTask task;

    boolean isRepeating;

    public PaperScheduledTask(final BukkitTask task) {
        this.task = task;
        this.isRepeating = false;
    }

    public PaperScheduledTask(final BukkitTask task, boolean isRepeating) {
        this.task = task;
        this.isRepeating = isRepeating;
    }

    @Override
    public void cancel() {
        task.cancel();
    }

    @Override
    public boolean isCancelled() {
        return task.isCancelled();
    }

    @Override
    public @NotNull Plugin getOwningPlugin() {
        return task.getOwner();
    }

    @Override
    public boolean isCurrentlyRunning() {
        return Bukkit.getServer().getScheduler().isCurrentlyRunning(this.task.getTaskId()); //There's no other way. Fuck bukkit
    }

    @Override
    public boolean isRepeatingTask() {
        return isRepeating;
    }
}
