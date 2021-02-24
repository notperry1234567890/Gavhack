package me.gavin.mimeware.client.module.mods;

import me.gavin.mimeware.client.events.LocalTickEvent;
import me.gavin.mimeware.client.module.Category;
import me.gavin.mimeware.client.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Category.Movement);
    }

    @EventHandler
    private Listener<LocalTickEvent> tickListener = new Listener<>(event -> {
        if (mc.player.moveForward > 0 && !mc.player.collidedHorizontally) {
            mc.player.setSprinting(true);
        }
    });
}
