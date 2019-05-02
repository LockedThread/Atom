package net.atom.atomcore.commands.handler;

import net.atom.atomcore.commands.arguments.Argument;
import net.atom.atomcore.objs.impl.AtomPlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public interface CommandHandler<T extends CommandSender> {

    AtomPlayer getAtomPlayer();

    T getSender();

    default boolean isConsole() {
        return getSender() instanceof ConsoleCommandSender;
    }

    default boolean isPlayer() {
        return getSender() instanceof Player;
    }

    default String getRawArgument(int index) {
        return getRawArguments().length >= index ? null : getRawArguments()[index];
    }

    default Argument<T> getArgument(Class<T> tClass, int index) {
        return new Argument<>(tClass, getRawArgument(index), index);
    }

    String[] getRawArguments();
}
