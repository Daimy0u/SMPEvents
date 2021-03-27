package daimyou.smpevents;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.ChatColor;

import java.util.HashMap;

public class eventTracker {
    HashMap<String, Integer> mobCount = new HashMap<String, Integer>();
    HashMap<String, Integer> pvpCount = new HashMap<String, Integer>();
    HashMap<String, Integer> expLevelGainedCount = new HashMap<String, Integer>();
    private Plugin plugin = main.getPlugin(main.class);
    public void updatePlayerCount(String playername, String value, int value2) {
        switch(value) {
            case "MOBCOUNT": {
                mobCount.put(playername, mobCount.get(playername) + value2);
                break;
            }
            case "PLAYERSKILLED": {
                pvpCount.put(playername, pvpCount.get(playername) + value2);
                break;
            }
            case "EXPLEVELGAIN": {
                expLevelGainedCount.put(playername, expLevelGainedCount.get(playername) + value2);
                break;
            }
            default: {
                break;
            }
        }
    }
    public void initializeTracker(Player player) {
        String name = player.getName();
        try {
            mobCount.put(name, (Integer) plugin.getConfig().get("players." + player.getUniqueId() + ".mobcount"));
        } catch (Exception e) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[SMPEvents] Can't Initialize Trackers!");
        }
        try {
            pvpCount.put(name, (Integer) plugin.getConfig().get("players." + player.getUniqueId() + ".pvpcount"));
        } catch (Exception e) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[SMPEvents] Can't Initialize Trackers!");
        }


    }
    public int getPlayerCount(String playername, String value) {
        switch(value) {
            case "MOBCOUNT": {
                return mobCount.get(playername);

            }
            case "PLAYERSKILLED": {
                return pvpCount.get(playername);
            }
            case "EXPLEVELGAIN": {
                return expLevelGainedCount.get(playername);
            }
            default: {
                break;
            }
        }
        return 0; //Return 0 if invalid
    }
}
