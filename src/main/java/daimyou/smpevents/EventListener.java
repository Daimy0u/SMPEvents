package daimyou.smpevents;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import daimyou.smpevents.eventTracker;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.entity.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class EventListener implements Listener {
    private Plugin plugin = main.getPlugin(main.class);
    eventTracker eventTrack = new eventTracker();

    @EventHandler
    public void onDeath(final EntityDeathEvent e){
        Entity entity = e.getEntity();
        if(e.getEntity().getKiller() == null) {
            return;
        }
        if (e.getEntity().getKiller() instanceof Player){
            try {
                Player player = (Player) e.getEntity().getKiller();
                eventTrack.updatePlayerCount(player.getName(), 1, 1);
                int tmp = plugin.getConfig().getInt("players." + player.getUniqueId() + ".mobcount") + 1;
                plugin.getConfig().set("players." + player.getUniqueId() + ".mobcount", tmp);
                plugin.saveConfig();
            } catch(Exception ex) {
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[SMPEvents] Exception at EntityDeathEvent!" + ex.getMessage());
            }

        }
    }

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        if (killer == null) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[SMPEvents] Error finding player in pvpevent!");
            return;
        }
        String name = e.getEntity().getKiller().getName();
        eventTrack.updatePlayerCount(name, 2, 1);
        int vvalue = plugin.getConfig().getInt("players." + killer.getUniqueId() + ".pvpcount") + 1;
        plugin.getConfig().set("players." + killer.getUniqueId() + ".pvpcount", vvalue);
        plugin.saveConfig();
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        eventTrack.initializeTracker(e.getPlayer());
        plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[SMPEvents] Initialized tracker for player " + e.getPlayer());
    }
}
//needs lvl addition