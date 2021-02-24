package me.gavin.mimeware.client.command.commands;

import me.gavin.mimeware.client.command.CommandBase;
import me.gavin.mimeware.client.misc.Utils;
import me.gavin.mimeware.client.module.Module;

public class LegitCMD extends CommandBase {
    public LegitCMD() {
        super("legit", "legit", "disables all mods");
    }

    @Override
    public void onCommand(String[] args, String message) {
        mimeware.modManager.getMods().forEach(Module::disable);
        Utils.printMSG("Disabled all mods");
    }
}
