package net.sao.core.sender;

import net.luckperms.api.model.user.User;
import net.sao.core.SaoCorePlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Sender {
    private final SaoCorePlugin plugin;
    private final User user;
    private final UUID uuid;
    private final Player sender;

    public Sender(SaoCorePlugin plugin, Player sender) {
        this.plugin = plugin;
        this.sender = sender;


        this.user = plugin.getPerms().getPlayerAdapter(Player.class).getUser((Player) sender);
        this.uuid = user.getUniqueId();

    }


    public SaoCorePlugin getPlugin() {
        return plugin;
    }

    public User getUser() {
        return user;
    }

    public UUID getUuid() {
        return uuid;
    }

    public CommandSender getSender() {
        return sender;
    }
    public Player getPlayer() {
        return (Player) sender;
    }
}
