package daimyou.smpevents;

import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[SMPEvents] Initialized SMPEvents, running on version 0.0.1" + ChatColor.RESET);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[SMPEvents] Deinitializing SMPEvents" + ChatColor.RESET);
    }
}
