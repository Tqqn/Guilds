package me.tqqn.guilds.guild;

import org.bukkit.entity.Player;

public class Guild {

    private String name;
    private Player owner;
    private GuildMembers members;

    public Guild(String name, Player owner, GuildMembers members) {
        this.name = name;
        this.members = members;
        this.owner = owner;
    }
    public Guild (String name, Player owner) {
        this.name = name;
        this.owner = owner;
    }

    public Player getOwner() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }

    public void setOwner(Player newowner) {
        this.owner = newowner;
    }

    public void setName(String newname) {
        this.name = newname;
    }
    public GuildMembers getMembers() {
        return this.members;
    }
}
