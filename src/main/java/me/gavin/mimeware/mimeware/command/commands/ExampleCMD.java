package me.gavin.mimeware.mimeware.command.commands;

import me.gavin.mimeware.mimeware.command.CommandBase;
import me.gavin.mimeware.mimeware.misc.Utils;

public class ExampleCMD extends CommandBase {
    public ExampleCMD() {
        super("lol", "lol poop", "l");
    }

    @Override
    public void onCommand(String[] args, String message) {
        if (args.length == 0) {
            Utils.printMSG("no args found");
            return;
        }

        if (args[0].equalsIgnoreCase("poop")) {
            Utils.printMSG("POOP LMAOOOOOO");
        }
    }
}
