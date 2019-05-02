package net.atom.atomcore;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class AtomCore extends JavaPlugin {

    private static AtomCore instance;
    private Economy economy;
    private Chat chat;
    private Permission permission;
    private long startupTime;

    @Override
    public void onEnable() {
        this.startupTime = System.currentTimeMillis();
        instance = this;
        setupVault();
        getLogger().info("Enabled AtomCore V-" + getDescription().getVersion() + " By: LockedThread & Eman0039 (" + (System.currentTimeMillis() - startupTime) + "ms)");
    }

    @Override
    public void onDisable() {

    }

    private void setupVault() {
        Plugin plugin = getServer().getPluginManager().getPlugin("Vault");
        if (plugin != null && plugin.getDescription().getVersion().startsWith("1.7")) {
            if (getConfig().getBoolean("vault.economy.enabled")) {
                RegisteredServiceProvider<Economy> economyRegisteredServiceProvider = getServer().getServicesManager().getRegistration(Economy.class);
                if (economyRegisteredServiceProvider != null) {
                    economy = economyRegisteredServiceProvider.getProvider();
                } else {
                    getLogger().severe("Having issues initializing Vault Economy! Contact the Atom team ASAP.");
                }
            }
            /*

            Must create implemented interfaces for these!

            RegisteredServiceProvider<Chat> chatRegisteredServiceProvider = getServer().getServicesManager().getRegistration(Chat.class);
            if (chatRegisteredServiceProvider != null) {
                chat = chatRegisteredServiceProvider.getProvider();
            } else {
                getLogger().severe("Having issues initializing Vault Chat! Contact the Atom team ASAP.");
            }
            RegisteredServiceProvider<Permission> permissionRegisteredServiceProvider = getServer().getServicesManager().getRegistration(Permission.class);
            if (permissionRegisteredServiceProvider != null) {
                permission = permissionRegisteredServiceProvider.getProvider();
            } else {
                getLogger().severe("Having issues initializing Vault Permission! Contact the Atom team ASAP.");
            }*/
            getLogger().info("Enabled Vault hook.");
        }
        getLogger().severe("You must have Vault version at least 1.7 installed to run this plugin!");
    }

    public Economy getEconomy() {
        return economy;
    }

    public Chat getChat() {
        return chat;
    }

    public Permission getPermission() {
        return permission;
    }

    public static AtomCore getInstance() {
        return instance;
    }

    public final long getStartupTime() {
        return startupTime;
    }
}
