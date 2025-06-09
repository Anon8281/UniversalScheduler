package com.github.Anon8281.universalScheduler.foliaScheduler;

import com.github.Anon8281.universalScheduler.scheduling.tasks.MyScheduledTask;
import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import org.bukkit.plugin.Plugin;

public class FoliaScheduledTask implements MyScheduledTask {
    private final ScheduledTask task;
    private final int taskId;

    public FoliaScheduledTask(final ScheduledTask task, int taskId) {
        this.task = task;
        this.taskId = taskId;
    }

    @Override
    public void cancel() {
        this.task.cancel();
    }

    @Override
    public boolean isCancelled() {
        return this.task.isCancelled();
    }

    @Override
    public Plugin getOwningPlugin() {
        return this.task.getOwningPlugin();
    }

    @Override
    public boolean isCurrentlyRunning() {
        final ScheduledTask.ExecutionState state = this.task.getExecutionState();
        return state == ScheduledTask.ExecutionState.RUNNING || state == ScheduledTask.ExecutionState.CANCELLED_RUNNING;
    }

    @Override
    public boolean isRepeatingTask() {
        return this.task.isRepeatingTask();
    }

    @Override
    public int getTaskId() {
        return taskId;
    }

    public boolean isFinished() {
        final ScheduledTask.ExecutionState state = this.task.getExecutionState();
        return state == ScheduledTask.ExecutionState.FINISHED;
    }
}