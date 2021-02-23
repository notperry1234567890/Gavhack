package me.gavin.mimeware.mimeware.misc;

import me.gavin.mimeware.Mimeware;
import me.gavin.mimeware.mimeware.events.PlayerChatEvent;
import me.gavin.mimeware.mimeware.events.Render2dEvent;
import me.gavin.mimeware.mimeware.events.Render3dEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
        mimeware.EVENT_BUS.post(new Render2dEvent(new ScaledResolution(mc)));
        mimeware.font.drawStringWithShadow(Mimeware.MOD_NAME + " " + Mimeware.VERSION, 2, 2, new Color(-1));

        mc.profiler.endSection();
        GlStateManager.popMatrix();
    }

    @SubscribeEvent
    public void onRender3d(RenderWorldLastEvent event) {
        GlStateManager.pushMatrix();
        mimeware.EVENT_BUS.post(new Render3dEvent());
        GlStateManager.popMatrix();
    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        PlayerChatEvent playerChatEvent = new PlayerChatEvent(event.getMessage());
        mimeware.EVENT_BUS.post(playerChatEvent);
        if (playerChatEvent.isCancelled())
            event.setCanceled(true);
    }
}
