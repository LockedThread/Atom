package net.atom.atomcore.commands;

import net.atom.atomcore.commands.handler.CommandHandler;

public abstract class Command {

    public abstract void execute(CommandHandler commandHandler);

    public @interface Name {
        String name();
    }

    public @interface Permission {
        String permission();
    }
}
