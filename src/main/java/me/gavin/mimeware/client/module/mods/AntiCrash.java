package me.gavin.mimeware.client.module.mods;

import me.gavin.mimeware.client.events.PacketEvent;
import me.gavin.mimeware.client.module.Category;
import me.gavin.mimeware.client.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.server.SPacketParticles;

public class AntiCrash extends Module {
    public AntiCrash() {
        super("AntiCrash", Category.Misc);
    }

    @EventHandler
    private Listener<PacketEvent.Receive> packetListener = new Listener<>(event -> {
         if (event.getPacket() instanceof SPacketParticles && ((SPacketParticles) event.getPacket()).getParticleCount() > 1000) {
             event.cancel();
         }
    });
}
