package net.atom.atomcore.exceptions;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.function.Consumer;

public class CommandParseException extends Throwable {

    private Consumer<CommandSender> senderConsumer;

    public CommandParseException(String type, int index) {
        this.senderConsumer = sender -> sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUnable to parse " + type + " at index " + index));
    }

    public CommandParseException(String message) {
        this.senderConsumer = sender -> sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public CommandParseException(Consumer<CommandSender> senderConsumer) {
        this.senderConsumer = senderConsumer;
    }

    public Consumer<CommandSender> getSenderConsumer() {
        return senderConsumer;
    }
}
