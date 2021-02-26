package me.gavin.gavhack.client.module.mods;

import me.gavin.gavhack.client.events.LocalTickEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class FastPlace extends Module {

    public BooleanSetting noBreakDelay = new BooleanSetting("NoBreakDelay", this, false);

    public FastPlace() {
        super("FastPlace", Category.World);
        addSettings(noBreakDelay);
    }

    @EventHandler
    private Listener<LocalTickEvent> tickListener = new Listener<>(event -> {
        mc.rightClickDelayTimer = 0;

        if (noBreakDelay.enabled) {
            mc.playerController.blockHitDelay = 0;
        }
    });
}
