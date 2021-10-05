package me.tqqn.guilds.utils;

import me.tqqn.guilds.Main;
import me.tqqn.guilds.guild.Guild;
import org.bukkit.Bukkit;

import java.util.UUID;

public class ConfigManager {

    public void loadGuilds() {
        for (String guild : Main.getInstance().getConfig().getConfigurationSection("guild").getKeys(false)) {
            Guild foundGuild = new Guild(guild, Bukkit.getPlayer(getGuildOwner(guild)));
            Main.getGuildManagerInstance().getGuildMap().put(guild.toLowerCase(), foundGuild);
        }
    }
    public UUID getGuildOwner(String name) {
        return UUID.fromString(Main.getInstance().getConfig().getString("guild." + name + ".owner"));
    }
    public void createGuild(String name, UUID owner) {
        Main.getInstance().getConfig().set("guild." + name + ".name", name);
        Main.getInstance().getConfig().set("guild." + name + ".owner", owner.toString());
    }
}
