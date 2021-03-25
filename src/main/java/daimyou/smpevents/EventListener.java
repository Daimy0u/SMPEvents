package daimyou.smpevents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import daimyou.smpevents.eventTracker;

public class EventListener extends eventTracker implements Listener {
    @EventHandler
    public void onDeath(EntityDeathEvent e){
        Entity entity = e.getEntity();
        Entity killer = e.getEntity().getKiller();

        if (killer instanceof Player){
            string name = Player.getName();
            eventTracker.updatePlayerCount(name, "MOBCOUNT");
        }
    }
}
