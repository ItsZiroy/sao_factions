package net.sao.core.command;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.sao.core.SaoCorePlugin;

import net.sao.core.command.abstraction.Command;
import net.sao.core.commands.factions.CreateFactionCommand;
import net.sao.core.sender.Sender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;


public class CommandManager implements CommandExecutor {

    private final SaoCorePlugin plugin;
    private final PluginCommand pluginCommand;
    private final ImmutableMap<String, Command> commands;
    public CommandManager(SaoCorePlugin plugin, PluginCommand command) {
        this.plugin = plugin;
        this.pluginCommand = command;

        CreateFactionCommand createFactionCommand = new CreateFactionCommand();

        this.commands = ImmutableMap.<String, Command>builder().put(createFactionCommand.getName(), createFactionCommand).build();

        this.register();

    }

    public void register() {
        this.pluginCommand.setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return false;
        }

        executeCommand(new Sender(this.plugin, (Player) sender), Arrays.asList(args));
        return true;
    }

    public void executeCommand(Sender sender, List<String> args) {
        Command command = this.commands.get(args.get(0));
        command.execute(this.plugin, sender, args);
    }
}
