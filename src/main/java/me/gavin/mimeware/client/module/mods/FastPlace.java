package me.gavin.mimeware.client.module.mods;

import me.gavin.mimeware.client.events.LocalTickEvent;
import me.gavin.mimeware.client.module.Category;
import me.gavin.mimeware.client.module.Module;
import me.gavin.mimeware.mixin.mixins.AccessorMinecraft;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class FastPlace extends Module {
    public FastPlace() {
        super("FastPlace", Category.World);
    }

    @EventHandler
    private Listener<LocalTickEvent> tickListener = new Listener<>(event -> {
        ((AccessorMinecraft) mc).setRightClickDelayTimer(0);
    });
}
