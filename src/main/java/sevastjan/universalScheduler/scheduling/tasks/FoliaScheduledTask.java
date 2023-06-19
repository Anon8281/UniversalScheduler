package sevastjan.universalScheduler.scheduling.tasks;

import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class FoliaScheduledTask implements MyScheduledTask {
    private final ScheduledTask task;

    public FoliaScheduledTask(final ScheduledTask task) {
        this.task = task;
    }

    public void cancel() {
        this.task.cancel();
    }

    public boolean isCancelled() {
        return this.task.isCancelled();
    }

    public @NotNull Plugin getOwningPlugin() {
        return this.task.getOwningPlugin();
    }

    public boolean isCurrentlyRunning() {
        final ScheduledTask.ExecutionState state = this.task.getExecutionState();
        return state == io.papermc.paper.threadedregions.scheduler.ScheduledTask.ExecutionState.RUNNING || state == ScheduledTask.ExecutionState.CANCELLED_RUNNING;
    }

    public boolean isRepeatingTask() {
        return this.task.isRepeatingTask();
    }
}