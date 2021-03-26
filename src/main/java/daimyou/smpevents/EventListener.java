package daimyou.smpevents;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import daimyou.smpevents.eventTracker;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.entity.*;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;
public class EventListener implements Listener {
    private Plugin plugin = main.getPlugin(main.class);
    eventTracker eventTrack = new eventTracker();
    @EventHandler
    public void onDeath(EntityDeathEvent e){
        Entity entity = e.getEntity();
        Entity killer = e.getEntity().getKiller();

        if (killer instanceof Player){
            Player player = e.getEntity().getKiller();
            eventTrack.updatePlayerCount(player.getName(), "MOBCOUNT");
            plugin.getConfig().set("players." + killer.getUniqueId() + ".pvpcount", (int) plugin.getConfig().get("players." + killer.getUniqueId() + "mobcount") + 1);
        }
    }

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        @Nullable Player killer = e.getEntity().getKiller();
        if (killer == null) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[SMPEvents] Error finding player in pvpevent!");
            return;
        }
        String name = e.getEntity().getKiller().getName();
        eventTrack.updatePlayerCount(name, "PLAYERSKILLED");
        int prevvalue = (int) plugin.getConfig().get("players." + killer.getUniqueId() + ".pvpcount");
        plugin.getConfig().set("players." + killer.getUniqueId() + ".pvpcount", prevvalue + 1);
    }
}
//needs lvl addition