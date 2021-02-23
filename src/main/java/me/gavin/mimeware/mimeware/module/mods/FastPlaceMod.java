package me.gavin.mimeware.mimeware.module.mods;

import me.gavin.mimeware.mimeware.events.LocalTickEvent;
import me.gavin.mimeware.mimeware.module.Category;
import me.gavin.mimeware.mimeware.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class FastPlaceMod extends Module {
    public FastPlaceMod() {
        super("FastPlace", Category.World);
    }

    @EventHandler
    private Listener<LocalTickEvent> tickListener = new Listener<>(event -> {

        // she doinu
    });
}
