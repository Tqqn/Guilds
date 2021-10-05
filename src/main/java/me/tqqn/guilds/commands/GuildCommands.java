package me.tqqn.guilds.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.*;
import me.tqqn.guilds.Main;
import me.tqqn.guilds.guild.Guild;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("guild")
@Description("Allows to use the guild commands.")

public class GuildCommands extends BaseCommand {

    public GuildCommands(Main main) {
    }

    @HelpCommand
    @Private
    public void help(CommandHelp help) {
        help.showHelp();
    }

    @Subcommand("create")
    @CommandPermission("guild.create")
    public void createGuild(CommandSender sender, String name) {
        Player player = (Player) sender;
        if (!Main.getGuildManagerInstance().existGuild(name)) {
            Main.getGuildManagerInstance().createGuild(name, player.getUniqueId());
            player.sendMessage("You created a guild with the name: " + name);
        }
        player.sendMessage("This guild name is already taken. Try another name.");
    }
    @Subcommand("invite")
    @CommandPermission("guild.invite")
    public void invitePlayer(CommandSender sender, Guild guild, String player) {

    }
}
