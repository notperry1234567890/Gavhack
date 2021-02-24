package me.gavin.mimeware.client.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gavin.mimeware.client.command.CommandBase;
import me.gavin.mimeware.client.misc.Utils;

public class ModulesCMD extends CommandBase {
    public ModulesCMD() {
        super("modules", "modules", "shows all modules", "mods");
    }

    @Override
    public void onCommand(String[] args, String message) {
        StringBuilder sb = new StringBuilder();


        mimeware.modManager.getMods().forEach(module -> {
            if (module.isEnabled()) {
                sb.append(ChatFormatting.GREEN + module.getName() + ChatFormatting.WHITE + ", ");
            } else {
                sb.append(ChatFormatting.RED + module.getName() + ChatFormatting.WHITE + ", ");
            }
        });

        Utils.printMSG("Modules: " + sb.substring(0, sb.length() - 2));
    }
}
