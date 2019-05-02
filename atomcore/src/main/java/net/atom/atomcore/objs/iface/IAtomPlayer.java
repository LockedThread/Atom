package net.atom.atomcore.objs.iface;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface IAtomPlayer {

    // Data & core methods

    void login();

    void logout();

    Player getPlayer();

    UUID getUUID();

    OfflinePlayer getOfflinePlayer();

    boolean isOnline();

    // Economy

    void setMoney(double money);

    double getMoney();

    EconomyResponse withdraw(double money);

    // Last login

    void setLastLoginTime(long time);

    long getLastLoginTime();



}
