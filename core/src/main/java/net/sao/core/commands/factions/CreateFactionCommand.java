package net.sao.core.commands.factions;

import net.sao.core.SaoCorePlugin;
import net.sao.core.command.abstraction.Command;
import net.sao.core.command.abstraction.CommandArgument;
import net.sao.core.command.abstraction.CommandMetaData;
import net.sao.core.command.permissions.CommandPermission;
import net.sao.core.sender.Sender;
import org.bukkit.ChatColor;

import java.util.List;

public class CreateFactionCommand extends Command {
    public CreateFactionCommand() {
        super("create", new CommandMetaData("Creates a new faction", "create", "Test"),
                CommandPermission.BASE, null);
    }

    @Override
    public void execute(SaoCorePlugin plugin, Sender sender, List<String> args) {
        sender.getPlayer().sendMessage(ChatColor.GREEN + "It works!");
    }
}
