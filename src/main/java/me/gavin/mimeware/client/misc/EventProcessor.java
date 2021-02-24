package me.gavin.mimeware.client.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gavin.mimeware.Mimeware;
import me.gavin.mimeware.client.events.KeyPressEvent;
import me.gavin.mimeware.client.events.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public class EventProcessor {

    Minecraft mc = Minecraft.getMinecraft();
    Mimeware mimeware = Mimeware.getMimeware();

    public EventProcessor() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text event) {
        if (mc.gameSettings.showDebugInfo)
            return;

        GlStateManager.pushMatrix();
        mc.profiler.startSection("mimeware");

        // where all on-screen renders are passed through
        ScaledResolution sr = new ScaledResolution(mc);
        mimeware.EVENT_BUS.post(new Render2dEvent(sr));
        Utils.drawRainbowFont(Mimeware.MOD_NAME + " " + Mimeware.VERSION, 2, 2);

        // coords
        Entity entity = this.mc.getRenderViewEntity();
        EnumFacing enumfacing = entity.getHorizontalFacing();
        String s = "Invalid";

        switch (enumfacing)
        {
            case NORTH:
                s = "North [-Z]";
                break;
            case SOUTH:
                s = "South [-Z]";
                break;
            case WEST:
                s = "West [-X]";
                break;
            case EAST:
                s = "East [+X]";
        }

        String XYZPos = String.format("XYZ %.1f, %.1f, %.1f", mc.player.posX, mc.player.posY, mc.player.posZ);

        Utils.drawRainbowFont(s, 2,  sr.getScaledHeight() - 6 - (mimeware.font.getHeight() * 2));
        Utils.drawRainbowFont(XYZPos, 2, sr.getScaledHeight() - 3 - mimeware.font.getHeight());


        mc.profiler.endSection();
        GlStateManager.popMatrix();
    }

    @SubscribeEvent
    public void onRender3d(RenderWorldLastEvent event) {
        GlStateManager.pushMatrix();
        mimeware.EVENT_BUS.post(new Render3dEvent());
        GlStateManager.popMatrix();
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onChat(ClientChatEvent event) {
        PlayerChatEvent.Pre playerChatEvent = new PlayerChatEvent.Pre(event.getMessage());
        mimeware.EVENT_BUS.post(playerChatEvent);
        if (playerChatEvent.isCancelled())
            event.setCanceled(true);

        event.setMessage(playerChatEvent.getMessage());
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onChatPost(ClientChatEvent event) {
        PlayerChatEvent.Post playerChatEvent = new PlayerChatEvent.Post(event.getMessage());
        mimeware.EVENT_BUS.post(playerChatEvent);
        if (playerChatEvent.isCancelled())
            event.setCanceled(true);

        event.setMessage(playerChatEvent.getMessage());
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (mc.world == null || mc.player == null)
            return;

        mimeware.EVENT_BUS.post(new LocalTickEvent());
    }

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKeyState()) {
            mimeware.modManager.getMods().forEach(module -> {
                if (Keyboard.getEventKey() == module.keyBind.getKeyCode())
                    module.toggle();
            });

            mimeware.EVENT_BUS.post(new KeyPressEvent(Keyboard.getEventKey()));
        }
    }
}
