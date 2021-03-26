package daimyou.smpevents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import daimyou.smpevents.eventTracker;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.entity.*;

public class EventListener implements Listener {
    eventTracker eventTrack = new eventTracker();
    @EventHandler
    public void onDeath(EntityDeathEvent e){
        Entity entity = e.getEntity();
        Entity killer = e.getEntity().getKiller();

        if (killer instanceof Player){
            Player player = e.getEntity().getKiller();
            eventTrack.updatePlayerCount(player.getName(), "MOBCOUNT");
        }
    }

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        String name = e.getEntity().getKiller().getName();
        eventTrack.updatePlayerCount(name, "PLAYERSKILLED");
    }
}
