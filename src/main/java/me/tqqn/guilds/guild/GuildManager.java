package me.tqqn.guilds.guild;

import me.tqqn.guilds.Main;

import java.util.HashMap;
import java.util.UUID;

public class GuildManager {

    private final HashMap<String, Guild> guilds = new HashMap<>();

    public void loadGuilds() {
        Main.getConfigManager().loadGuilds();
    }

    public HashMap<String, Guild> getGuildMap() {
        return guilds;
    }
    public void createGuild( String guildname, UUID owner) {
        Main.getConfigManager().createGuild(guildname, owner);
    }
    public boolean existGuild(String name) {
        return guilds.containsKey(name.toLowerCase());
    }
}
