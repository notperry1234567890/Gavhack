package me.gavin.mimeware.mimeware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gavin.mimeware.mimeware.command.CommandBase;
import me.gavin.mimeware.mimeware.misc.Utils;
import me.gavin.mimeware.mimeware.module.Module;

public class ToggleCMD extends CommandBase {
    public ToggleCMD() {
        super("toggle", "toggle <module>", "t");
    }

    @Override
    public void onCommand(String[] args, String message) {
        if (args.length == 0) {
            Utils.printMSG("Please specify a module");
            return;
        }

        Module targetMod = mimeware.modManager.getMod(args[0]);

        if (targetMod == null) {
            Utils.printMSG("Could not find a module with that name");
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
