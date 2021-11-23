package net.sao.core;

import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class SaoCorePlugin extends JavaPlugin {

    @Override
    public void onLoad() {
        try {
            RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
            if (provider != null) {
                LuckPerms api = provider.getProvider();
                getServer().broadcastMessage("Loaded LuckPerms");
            }
        } catch (Exception e) {
            getServer().broadcastMessage(ChatColor.RED + "LuckPerms not loaded!");
        }

        getServer().broadcastMessage("Successfully Loaded SAO");
        super.onLoad();
    }

    @Override
    public void onEnable() {
        getServer().broadcastMessage("Successfully Enabled SAO");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
