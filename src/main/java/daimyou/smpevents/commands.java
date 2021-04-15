package daimyou.smpevents;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class commands implements CommandExecutor {
    private Plugin plugin = main.getPlugin(main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("setevent")) {
            if (args.length == 1) {
                if (args[0] == "mob") {
                    plugin.getConfig().set("active-event", "mob");
                    plugin.saveConfig();
                    sender.sendMessage(ChatColor.GREEN + "[SMPEvents] Set Active Event to " + plugin.getConfig().getString("active-event") + "!");
                }
                else if (args[0] == "pvp") {
                    plugin.getConfig().set("active-event", "pvp");
                    plugin.saveConfig();
                    sender.sendMessage(ChatColor.GREEN + "[SMPEvents] Set Active Event to " + plugin.getConfig().getString("active-event") + "!");
                }
                else {
                    sender.sendMessage(ChatColor.RED + "[SMPEvents] Invalid Event: " + args[0] + "!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "[SMPEvents] Invalid Parameters!");

            }

        }
        return true;
    }
    public List<String> onTabComplete(CommandSender sender, Command cmd, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setevent") && args.length == 1) {
            List<String> list = new ArrayList<String>();
            list.add("mob");
            list.add("pvp");
            return list;
        }
        return null;
    }
}
