package daimyou.smpevents;


public class eventTracker {
    HashMap<string, integer> mobCount = new HashMap<string, integer>();
    HashMap<string, integer> pvpCount = new HashMap<string, integer>();
    HashMap<string, integer> expLevelGainedCount = new HashMap<string, integer>();
    public static void updatePlayerCount(string playername, string value) {
        switch(value) {
            case MOBCOUNT: {
                int newvalue = mobCount.get(playername) + 1;
                mobCount.put(playername, newvalue);
                break;
            }
            case PLAYERSKILLED: {
                pvpCount.put(playername, pvpCount.get(playername) + 1);
                break;
            }
            case EXPLEVELGAIN: {
                expLevelGainedCount.put(playername, expLevelGainedCount.get(playername) + 1);
                break;
            }
            default: {
                break;
            }
        }
    }
    public static int getPlayerCount(string playername, string value) {
        switch(value) {
            case MOBCOUNT: {
                return mobCount.get(playername);

            }
            case PLAYERSKILLED: {
                return pvpCount.get(playername);
            }
            case EXPLEVELGAIN: {
                return expLevelGainedCount.get(playername);
            }
            default: {
                break;
            }
        }
        return 0; //Return 0 if invalid
    }
}
