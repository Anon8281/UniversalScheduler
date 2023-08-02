package com.github.Anon8281.universalScheduler.foliaScheduler;

import com.github.Anon8281.universalScheduler.scheduling.tasks.MyScheduledTask;
import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Random;

public class FoliaScheduledTask implements MyScheduledTask {
    private final ScheduledTask task;
    static final HashMap<Integer, ScheduledTask> tasks = new HashMap<>();
    private int taskId;

    public FoliaScheduledTask(final ScheduledTask task) {
        this.task = task;
        do {
            taskId = new Random().nextInt();
        } while (tasks.containsKey(taskId));
        tasks.put(taskId, task);
    }

    public void cancel() {
        this.task.cancel();
    }

    public boolean isCancelled() {
        return this.task.isCancelled();
    }

    public Plugin getOwningPlugin() {
        return this.task.getOwningPlugin();
    }

    public boolean isCurrentlyRunning() {
        final ScheduledTask.ExecutionState state = this.task.getExecutionState();
        return state == ScheduledTask.ExecutionState.RUNNING || state == ScheduledTask.ExecutionState.CANCELLED_RUNNING;
    }

    public boolean isRepeatingTask() {
        return this.task.isRepeatingTask();
    }

    /**
     * @author DreamVoid
     */
    @Override
    public int getTaskId() {
        return taskId;
    }
}