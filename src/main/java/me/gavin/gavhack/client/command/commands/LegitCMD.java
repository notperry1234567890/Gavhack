package me.gavin.gavhack.client.command.commands;

import me.gavin.gavhack.Gavhack;
import me.gavin.gavhack.client.command.CommandBase;
import me.gavin.gavhack.client.misc.Utils;
import me.gavin.gavhack.client.module.Module;

public class LegitCMD extends CommandBase {
    public LegitCMD() {
        super("legit", "legit", "disables all mods");
    }

    @Override
    public void onCommand(String[] args, String message) {
        Gavhack.modManager.getMods().forEach(Module::disable);
        Utils.printMSG("Disabled all mods");
    }
}