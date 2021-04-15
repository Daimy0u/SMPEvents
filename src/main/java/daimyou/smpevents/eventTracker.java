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
    public void updatePlayerCount(String playername, int value, int value2) {
        switch(value) {
            case 1: {
                mobCount.put(playername, mobCount.get(playername) + value2);
                break;
            }
            case 2: {
                pvpCount.put(playername, pvpCount.get(playername) + value2);
                break;
            }
            case 3: {
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
            if (plugin.getConfig().getString("players." + player.getUniqueId() + ".mobcount") == null) {
                plugin.getConfig().set("players." + player.getUniqueId() + ".mobcount", 0);
                plugin.saveConfig();
            }
            String a = plugin.getConfig().getString("players." + player.getUniqueId() + ".mobcount");
            int aa = Integer.parseInt(a);
            mobCount.put(name, aa);
        } catch (Exception e) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[SMPEvents] Can't Initialize Trackers: " + e.getMessage());
        }
        try {
            if (plugin.getConfig().getString("players." + player.getUniqueId() + ".pvpcount") == null) {
                plugin.getConfig().set("players." + player.getUniqueId() + ".pvpcount", 0);
                plugin.saveConfig();
            }
            String a = plugin.getConfig().getString("players." + player.getUniqueId() + ".pvpcount");
            int aa = Integer.parseInt(a);
            mobCount.put(name, aa);
        } catch (Exception e) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[SMPEvents] Can't Initialize Trackers: " + e.getMessage());
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
