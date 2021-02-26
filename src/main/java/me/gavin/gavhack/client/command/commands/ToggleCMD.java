package me.gavin.gavhack.client.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gavin.gavhack.Gavhack;
import me.gavin.gavhack.client.command.CommandBase;
import me.gavin.gavhack.client.misc.Utils;
import me.gavin.gavhack.client.module.Module;

public class ToggleCMD extends CommandBase {
    public ToggleCMD() {
        super("toggle", "toggle <module>", "toggles a specified module", "t");
    }

    @Override
    public void onCommand(String[] args, String message) {
        if (args.length == 0) {
            sendSyntaxError();
            return;
        }

        Module targetMod = Gavhack.modManager.getMod(args[0]);

        if (targetMod == null) {
            Utils.printMSG("Could not find a module with that name");
            sendSyntaxError();
            return;
        }

        if (targetMod.isEnabled()) {
            Utils.printMSG(ChatFormatting.RED + "disabled " + ChatFormatting.RESET + targetMod.getName());
        } else {
            Utils.printMSG(ChatFormatting.GREEN + "enabled " + ChatFormatting.RESET + targetMod.getName());
        }

        targetMod.toggle();
    }
}