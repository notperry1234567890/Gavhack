package me.gavin.gavhack.client.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gavin.gavhack.Gavhack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class Utils {

    private static Minecraft mc = Minecraft.getMinecraft();

    public static void printMSG(String message) {
        mc.player.sendMessage(new TextComponentString(ChatFormatting.RED + "[Gavhack] " + ChatFormatting.RESET + message));
    }

    public static void playClick() {
        Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getRecord(SoundEvents.UI_BUTTON_CLICK, 1.0F, 0.25F));
    }

    public static int getRGBWave(float seconds, float brightness, float saturation, long index) {
        float hue = ((System.currentTimeMillis() + index) % (int) (seconds * 1000)) / (seconds * 1000);
        return Color.HSBtoRGB(hue, saturation, brightness);
    }

    public static int getRGB(float seconds, float brightness, float saturation) {
        float hue = (System.currentTimeMillis() % (int) (seconds * 1000)) / (seconds * 1000);
        return Color.HSBtoRGB(hue, saturation, brightness);
    }

    // thanks to bon for giving me the "chinese" method to having rainbow text
    // chat formatting codes do NOT work with this
    public static void drawRainbowFont(String text, int x, int y) {
        double xOffset = 0;
        char[] charArray = text.toCharArray();
        for (char c : charArray) {
            Gavhack.cfont.drawStringWithShadow(String.valueOf(c), x + xOffset, y, new Color(getRGBWave(10, 1, 0.6f, 35L * (long) xOffset)));
            xOffset += Gavhack.cfont.getStringWidth(String.valueOf(c)) + 0.275;
        }
    }
}