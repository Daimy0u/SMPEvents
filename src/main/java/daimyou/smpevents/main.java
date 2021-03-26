package daimyou.smpevents;

import me.clip.placeholderapi.PlaceholderHook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import me.clip.placeholderapi.PlaceholderAPI;
import daimyou.smpevents.EventListener;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[SMPEvents] Initialized SMPEvents, running on version 0.0.1");
        loadConfig();
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[SMPEvents] Deinitializing SMPEvents");
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        getConfig().addDefault("active-event", "none");
        saveConfig();
    }
}
