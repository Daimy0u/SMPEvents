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
    public void onDeath(EntityDeathEvent e){
        Entity entity = e.getEntity();
        if(e.getEntity().getKiller() == null) {
            return;
        }
        if (e.getEntity().getKiller() instanceof Player){
            try {
                Player player = e.getEntity().getKiller();
                eventTrack.updatePlayerCount(player.getName(), "MOBCOUNT", 1);
                plugin.getConfig().set("players." + player.getUniqueId() + ".pvpcount", (int) plugin.getConfig().get("players." + player.getUniqueId() + "mobcount") + 1);
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
        eventTrack.updatePlayerCount(name, "PLAYERSKILLED", 1);
        int prevvalue = (int) plugin.getConfig().get("players." + killer.getUniqueId() + ".pvpcount");
        plugin.getConfig().set("players." + killer.getUniqueId() + ".pvpcount", prevvalue + 1);
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        eventTrack.initializeTracker(e.getPlayer());
        plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[SMPEvents] Initialized tracker for player " + e.getPlayer());
    }
}
//needs lvl addition