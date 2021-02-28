package me.gavin.gavhack.client.module.mods;

import me.gavin.gavhack.client.events.LocalTickEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import me.gavin.gavhack.client.setting.impl.NumberSetting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class Step extends Module {

    public BooleanSetting reverse = new BooleanSetting("Reverse", this, false);
    public NumberSetting height = new NumberSetting("Height", this, 1.0, 0.5, 8.0, 0.5);
    public NumberSetting reverseForce = new NumberSetting("ReverseForce", this,10.0, 0.0, 20.0, 1.0);

    public Step() {
        super("Step", Category.Movement);
        addSettings(reverse, height, reverseForce);
    }

    @EventHandler
    private Listener<LocalTickEvent> tickListener = new Listener<>(event -> {
        mc.player.stepHeight = (float) height.getValue();

        if (reverse.enabled && mc.player.onGround && !mc.player.inWater && !mc.player.isInLava()) {
            mc.player.motionY -= reverseForce.getValue();
        }
    });

    public void onDisable() {
        mc.player.stepHeight = 0.5f;
    }
}
