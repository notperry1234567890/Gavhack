package me.gavin.gavhack.client.module.mods;

import me.gavin.gavhack.client.events.LocalTickEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.init.Items;

public class FastUtil extends Module {

    public BooleanSetting crystals = new BooleanSetting("Crystals", this,true);
    public BooleanSetting xp = new BooleanSetting("XP", this,true);

    public FastUtil() {
        super("FastUtil", Category.Combat);
        addSettings(xp, crystals);
    }

    @EventHandler
    private Listener<LocalTickEvent> tickListener = new Listener<>(event -> {
        if (xp.enabled) {
            if (mc.player.getHeldItemMainhand().getItem() == Items.EXPERIENCE_BOTTLE || mc.player.getHeldItemOffhand().getItem() == Items.EXPERIENCE_BOTTLE) {
                mc.rightClickDelayTimer = 0;
            }
        }

        if (crystals.enabled) {
            if (mc.player.getHeldItemMainhand().getItem() == Items.END_CRYSTAL || mc.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL) {
                mc.rightClickDelayTimer = 0;
            }
        }
    });
}
