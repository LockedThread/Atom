package net.atom.atomcore.commands.arguments;

import net.atom.atomcore.exceptions.CommandParseException;

import java.util.Objects;
import java.util.Optional;

public class Argument<T> implements IArgumentParser<T> {

    private final String rawArgument;
    private final int index;
    private final Class<T> tClass;

    public Argument(Class<T> tClass, String rawArgument, int index) {
        this.rawArgument = rawArgument;
        this.index = index;
        this.tClass = tClass;
    }

    public String getRawArgument() {
        return rawArgument;
    }

    @Override
    public T parseOrFail() throws CommandParseException {
        Optional<T> parse = parse();
        if (parse.isPresent()) {
            return parse.get();
        }
        throw new CommandParseException(rawArgument, index);
    }

    @Override
    public Optional<T> parseOrDefault(T or) {
        return parse().isPresent() ? parse() : Optional.of(or);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<T> parse() {
        return Optional.ofNullable((T) ArgumentParserRegistry.getInstance().getArgumentParserMap().get(tClass).apply(rawArgument));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Argument<?> argument = (Argument<?>) o;

        return Objects.equals(rawArgument, argument.rawArgument);
    }

    @Override
    public int hashCode() {
        return rawArgument != null ? rawArgument.hashCode() : 0;
    }
}
