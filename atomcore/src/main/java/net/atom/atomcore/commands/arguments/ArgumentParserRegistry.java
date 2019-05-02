package net.atom.atomcore.commands.arguments;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ArgumentParserRegistry {

    private static ArgumentParserRegistry instance;

    private Map<Class, Function<String, ?>> argumentParserMap;

    private ArgumentParserRegistry() {
        this.argumentParserMap = new HashMap<>();
        register();
    }

    private void register() {
        argumentParserMap.put(int.class, s -> {
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException ignored) {
                return null;
            }
        });
    }

    public Map<Class, Function<String, ?>> getArgumentParserMap() {
        return argumentParserMap;
    }

    public static ArgumentParserRegistry getInstance() {
        return instance == null ? instance = new ArgumentParserRegistry() : instance;
    }
}
