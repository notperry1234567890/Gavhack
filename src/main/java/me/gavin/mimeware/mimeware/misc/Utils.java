package me.gavin.mimeware.mimeware.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class Utils {

    private static Minecraft mc = Minecraft.getMinecraft();

    public static void printMSG(String message) {
        mc.player.sendMessage(new TextComponentString(ChatFormatting.GOLD + "[Mimeware] " + ChatFormatting.RESET + message));
    }
}
