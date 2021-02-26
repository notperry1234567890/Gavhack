package me.gavin.gavhack.client.module.mods;

import me.gavin.gavhack.client.events.Render3dEvent;
import me.gavin.gavhack.client.misc.RenderUtil;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.AxisAlignedBB;

import java.awt.*;

public class ESP extends Module {
    public ESP() {
        super("ESP", Category.Render);
    }

    @EventHandler
    private Listener<Render3dEvent> render3dListener = new Listener<>(event -> {
        for (Entity e : mc.world.getLoadedEntityList()) {
            if (e instanceof EntityLiving) {
                AxisAlignedBB box = e.boundingBox.offset(- mc.renderManager.renderPosX, -mc.renderManager.renderPosY, -mc.renderManager.renderPosZ);
                Color distanceColor = RenderUtil.getDistanceColor((int) mc.player.getDistance(e));
                GlStateManager.pushMatrix();
                RenderUtil.drawOutline(box, -distanceColor.getRed(), -distanceColor.getGreen(), -distanceColor.getBlue(), 120 / 255f);
                GlStateManager.popMatrix();
            }
        }
    });
}
