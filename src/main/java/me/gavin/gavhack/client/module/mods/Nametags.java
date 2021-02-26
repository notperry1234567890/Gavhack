package me.gavin.gavhack.client.module.mods;

import me.gavin.gavhack.client.events.Render3dEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class Nametags extends Module {
    public Nametags() {
        super("Nametags", Category.Render);
    }

    @EventHandler
    private Listener<Render3dEvent> render3dListener = new Listener<>(event -> {
        for (Entity e : mc.world.getLoadedEntityList()) {
            if (e instanceof EntityPlayer) {
                if (!e.equals(mc.player)) {

                }
                //RenderUtil.drawNametag(e, new String[]{e.getName()}, new Color(255, 0, 0), 2);
            }
        }
    });
}
