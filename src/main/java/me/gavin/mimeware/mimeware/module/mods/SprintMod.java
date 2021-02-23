package me.gavin.mimeware.mimeware.module.mods;

import me.gavin.mimeware.mimeware.events.LocalTickEvent;
import me.gavin.mimeware.mimeware.module.Category;
import me.gavin.mimeware.mimeware.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class SprintMod extends Module {
    public SprintMod() {
        super("Sprint", Category.Movement);
    }


    @EventHandler
    private Listener<LocalTickEvent> tickListener = new Listener<>(event -> {
        if (mc.player.moveForward > 0 && !mc.player.collidedHorizontally)
            mc.player.setSprinting(true);
    });
}
