package net.atom.atomcore.objs.impl;

import net.atom.atomcore.AtomCore;
import net.atom.atomcore.objs.iface.IAtomPlayer;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Objects;
import java.util.UUID;

public class AtomPlayer implements IAtomPlayer {

    private UUID uuid;
    private double money;
    private long lastLogin;

    private transient Player player;

    public AtomPlayer(Player player) {
        Objects.requireNonNull(player, "You can't initialize a null player! Contact the Atom team ASAP.");
        if (player.isOnline()) {
            this.player = player;
        }
        this.uuid = player.getUniqueId();
        this.lastLogin = System.currentTimeMillis();

        if (AtomCore.getInstance().getConfig().getBoolean("vault.economy.enabled")) {
            this.money = AtomCore.getInstance().getConfig().getDouble("vault.economy.starting-money");
        }
    }

    public AtomPlayer(UUID uuid) {
        this.uuid = uuid;
        this.lastLogin = System.currentTimeMillis();

        if (AtomCore.getInstance().getConfig().getBoolean("vault.economy.enabled")) {
            this.money = AtomCore.getInstance().getConfig().getDouble("vault.economy.starting-money");
        }
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {
        this.player = null;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public OfflinePlayer getOfflinePlayer() {
        return isOnline() ? player : Bukkit.getOfflinePlayer(uuid);
    }

    @Override
    public boolean isOnline() {
        return player != null && player.isOnline();
    }

    @Override
    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public double getMoney() {
        return money;
    }

    @Override
    public EconomyResponse withdraw(double money) {
        Economy economy = AtomCore.getInstance().getEconomy();
        if (economy != null) {
            return economy.withdrawPlayer(getOfflinePlayer(), money);
        }
        return null;
    }

    @Override
    public void setLastLoginTime(long time) {
        this.lastLogin = time;
    }

    @Override
    public long getLastLoginTime() {
        return lastLogin;
    }
}
