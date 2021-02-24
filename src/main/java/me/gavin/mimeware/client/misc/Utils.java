package me.gavin.mimeware.client.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.text.TextComponentString;

public class Utils {

    private static Minecraft mc = Minecraft.getMinecraft();

    public static void printMSG(String message) {
        mc.player.sendMessage(new TextComponentString(ChatFormatting.GOLD + "[Mimeware] " + ChatFormatting.RESET + message));
    }

    public static void playClick() {
        Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getRecord(SoundEvents.UI_BUTTON_CLICK, 1.0F, 0.25F));
    }
}
