package me.gavin.mimeware.mimeware.command;

import me.gavin.mimeware.mimeware.misc.Utils;

import java.util.Arrays;
import java.util.List;

public abstract class CommandBase {

    private String name, syntax;
    private List<String > aliases;

    public CommandBase(String name, String syntax, String... aliases) {
        this.name = name;
        this.syntax = syntax;
        this.aliases = Arrays.asList(aliases);
    }

    public abstract void onCommand(String[] args, String message);

    public String getName() {
        return name;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public String getSyntax() {
        return syntax;
    }

    private void sendSyntaxError() {
        Utils.printMSG("Syntax error, " + syntax);
    }
}
