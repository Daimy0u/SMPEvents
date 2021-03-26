package daimyou.smpevents;
import org.bukkit.entity.Player;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import daimyou.smpevents.main;
import org.bukkit.plugin.Plugin;

public abstract class placeholderIntegration extends PlaceholderExpansion {
    private main plugin;
    private Plugin plug = main.getPlugin(main.class);

    @Override
    public boolean canRegister() {
        return true;
    }
    @Override
    public String getAuthor(){
        return "Daimyou";
    }
    @Override
    public String getIdentifier(){
        return "smpevents";
    }
    @Override
    public String getVersion(){
        return "0.0.1";
    }

    public String onRequest(Player player, String identifier){

        //smpevents_mobcount
        if(identifier.equals("mobcount")){
            return (String) plugin.getConfig().get("players." + player.getUniqueId() + ".mobcount");
        }

        //smpevents_pvpcount
        if(identifier.equals("pvpcount")){
            return (String) plugin.getConfig().get("players." + player.getUniqueId() + ".pvpcount");
        }

        //smpevents_lvlcount
        if(identifier.equals("lvlcount")){
            return (String) plugin.getConfig().get("players." + player.getUniqueId() + ".lvlcount");
        }

        // We return null if an invalid placeholder (f.e. %example_placeholder3%)
        // was provided
        return null;
    }
}
