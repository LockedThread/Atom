package net.atom.atomcore.commands.arguments;

import net.atom.atomcore.exceptions.CommandParseException;

import java.util.Optional;

public interface IArgumentParser<T> {

    T parseOrFail() throws CommandParseException;

    Optional<T>  parseOrDefault( T or);

    Optional<T> parse();

}
