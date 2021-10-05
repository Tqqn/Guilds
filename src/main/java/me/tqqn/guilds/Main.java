package me.tqqn.guilds;

import co.aikar.commands.BukkitMessageFormatter;
import co.aikar.commands.MessageType;
import co.aikar.commands.PaperCommandManager;
import me.tqqn.guilds.commands.GuildCommands;
import me.tqqn.guilds.guild.GuildManager;
import me.tqqn.guilds.utils.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    private static PaperCommandManager manager;

    private static GuildManager guildManager;

    private static ConfigManager configManager;

    @Override
    public void onEnable() {
        instance = this;

        guildManager.loadGuilds();

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands() {
        manager = new PaperCommandManager(this);
        manager.enableUnstableAPI("help");

        manager.setFormat(MessageType.ERROR, new BukkitMessageFormatter(ChatColor.RED, ChatColor.YELLOW, ChatColor.RED));
        manager.setFormat(MessageType.SYNTAX, new BukkitMessageFormatter(ChatColor.DARK_GREEN, ChatColor.GREEN, ChatColor.WHITE));
        manager.setFormat(MessageType.INFO, new BukkitMessageFormatter(ChatColor.DARK_GREEN, ChatColor.GREEN, ChatColor.WHITE));
        manager.setFormat(MessageType.HELP, new BukkitMessageFormatter(ChatColor.DARK_GREEN, ChatColor.GREEN, ChatColor.WHITE));

        manager.registerCommand(new GuildCommands(this));

        manager.setDefaultExceptionHandler((command, registeredCommand, sender, args, t) -> {
            getLogger().warning("Error occurred with command " + command.getName());
            return false;
        });
    }

    public static Main getInstance() {
        return instance;
    }

    public static GuildManager getGuildManagerInstance() {
        return guildManager;
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }
}
