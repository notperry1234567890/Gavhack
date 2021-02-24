package me.gavin.mimeware.client.command.commands;

import me.gavin.mimeware.client.command.CommandBase;
import me.gavin.mimeware.client.misc.Utils;

public class HelpCMD extends CommandBase {
    public HelpCMD() {
        super("help", "help", "shows all commands");
    }

    @Override
    public void onCommand(String[] args, String message) {

        StringBuilder sb = new StringBuilder();
        for (CommandBase commandBase : mimeware.commandManager.getCommands()) {
            sb.append(commandBase.getName().concat(", "));
        }

        String cmds = sb.substring(0, sb.length() - 2);

        Utils.printMSG("Commands: " + cmds);
    }
}
