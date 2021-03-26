package daimyou.smpevents;
import java.util.HashMap;

public class eventTracker {
    HashMap<String, Integer> mobCount = new HashMap<String, Integer>();
    HashMap<String, Integer> pvpCount = new HashMap<String, Integer>();
    HashMap<String, Integer> expLevelGainedCount = new HashMap<String, Integer>();
    public void updatePlayerCount(String playername, String value) {
        switch(value) {
            case "MOBCOUNT": {
                int newvalue = mobCount.get(playername) + 1;
                mobCount.put(playername, newvalue);
                break;
            }
            case "PLAYERSKILLED": {
                pvpCount.put(playername, pvpCount.get(playername) + 1);
                break;
            }
            case "EXPLEVELGAIN": {
                expLevelGainedCount.put(playername, expLevelGainedCount.get(playername) + 1);
                break;
            }
            default: {
                break;
            }
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
