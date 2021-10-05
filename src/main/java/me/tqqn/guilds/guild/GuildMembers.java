package me.tqqn.guilds.guild;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GuildMembers {

    private String owner;
    private Guild guild;
    private String guildname;
    private ArrayList<String> officers;
    private ArrayList<String> members;

    public GuildMembers(String owner, Guild guild, String guildname, ArrayList<String> officers, ArrayList<String> members) {
        this.owner = owner;
        this.guild = guild;
        this.guildname = guildname;
        this.officers = officers;
        this.members = members;
    }

    public void addOfficers(Player player, String officer) {
        if (containsMember(officer)) {
            if (!containsOfficer(officer)) {
                officers.add(officer);
                player.sendMessage("Speler " + Bukkit.getPlayer(officer) + " is gepromoveerd tot Officer.");
            }
            player.sendMessage("Speler " + Bukkit.getPlayer(officer) + " is al Officer.");
        }
        player.sendMessage("Speler " + Bukkit.getPlayer(officer) + " is niet in de guild.");
    }

    public void addMember(Player player) {
        if (!containsMember(player.toString())) {
            if (!containsOfficer(player.toString())) {
                members.add(player.getUniqueId().toString());
            }
        }
    }

    public boolean containsOfficer(String officer) {
        return this.officers.contains(officer);
    }

    public boolean containsMember(String member) {
        return this.members.contains(member);
    }
}
