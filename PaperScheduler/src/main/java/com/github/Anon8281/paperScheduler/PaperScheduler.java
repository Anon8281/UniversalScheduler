package com.github.Anon8281.paperScheduler;

import com.github.Anon8281.foliaScheduler.FoliaScheduler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

//Thanks to Towny
public class PaperScheduler extends FoliaScheduler {
    public PaperScheduler(Plugin plugin) {
        super(plugin);
    }

    @Override
    public boolean isGlobalThread() {
        // isGlobalThread does not exist on paper, match the bukkit task scheduler's behaviour.
        return Bukkit.getServer().isPrimaryThread();
    }
}
