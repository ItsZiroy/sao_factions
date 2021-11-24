package net.sao.core;

import net.luckperms.api.LuckPerms;
import net.sao.core.command.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class SaoCorePlugin extends JavaPlugin {

    public LuckPerms getPerms() {
        return perms;
    }

    private LuckPerms perms;

    private CommandManager commandManager;

    @Override
    public void onLoad() {
        getServer().broadcastMessage(ChatColor.GREEN + "Successfully Loaded SAO");
    }

    @Override
    public void onEnable() {
        try {
            RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
            if (provider != null) {
                this.perms =  provider.getProvider();
                getServer().broadcastMessage(ChatColor.DARK_AQUA + "Loaded LuckPerms");
            }
        } catch (Exception e) {
            getServer().broadcastMessage(ChatColor.DARK_RED + "LuckPerms not loaded!");
        }
        this.registerCommands();
        getServer().broadcastMessage(ChatColor.GREEN + "Successfully Enabled SAO");

    }
    private void registerCommands() {
        PluginCommand command = this.getCommand("sao");
        if(command == null) {
            getLogger().severe("Unable to register /sao command.");
            return;
        }

        this.commandManager = new CommandManager(this, command);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
