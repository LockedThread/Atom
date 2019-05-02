package net.atom.atomcore.commands;

import net.atom.atomcore.commands.handler.CommandHandler;

@Command.Name(name = "atom")
@Command.Permission(permission = "yourmom.shit")
public class AtomCommand extends Command {

    @Override
    public void execute(CommandHandler commandHandler) {
        if (commandHandler.isPlayer()) {

        }
    }
}
