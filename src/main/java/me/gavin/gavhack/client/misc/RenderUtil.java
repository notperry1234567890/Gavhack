package me.gavin.gavhack.client.misc;

import me.gavin.gavhack.Gavhack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class RenderUtil {
    protected static Minecraft mc = Minecraft.getMinecraft();

    public static void prepareGL() {
        GL11.glPushMatrix();
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glLineWidth(3);
    }

    public static void releaseGL() {
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    public static AxisAlignedBB generateBB(long x, long y, long z) {
        BlockPos blockPos = new BlockPos(x, y, z);
        final AxisAlignedBB bb = new AxisAlignedBB
                (
                        blockPos.getX() - mc.getRenderManager().viewerPosX,
                        blockPos.getY() - mc.getRenderManager().viewerPosY,
                        blockPos.getZ() - mc.getRenderManager().viewerPosZ,
                        blockPos.getX() + 1 - mc.getRenderManager().viewerPosX,
                        blockPos.getY() + (1) - mc.getRenderManager().viewerPosY,
                        blockPos.getZ() + 1 - mc.getRenderManager().viewerPosZ
                );
        return bb;
    }

    public static void drawBox(AxisAlignedBB bb, float r, float g, float b, float a) {
        prepareGL();
        RenderGlobal.renderFilledBox(bb, r, g, b, a);
        releaseGL();
    }

    public static void drawBoxOutline(AxisAlignedBB bb, float r, float g, float b, float a) {
        prepareGL();
        RenderGlobal.renderFilledBox(bb, r, g, b, a);
        RenderGlobal.drawSelectionBoundingBox(bb, r, g, b, a * 1.5F);
        releaseGL();
    }

    public static void drawOutline(AxisAlignedBB bb, float r, float g, float b, float a) {
        prepareGL();
        RenderGlobal.drawSelectionBoundingBox(bb, r, g, b, a * 1.5F);
        releaseGL();
    }

    public static Color getDistanceColor(int distance) {
        if (distance > 50) {
            distance = 50;
        }

        int red = (int) (255 - (distance * 5.1));
        int green = 255 - red;

        return new Color(red, green, 0, 255);
    }
}