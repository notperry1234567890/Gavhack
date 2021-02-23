package me.gavin.mimeware.mimeware.module.mods;

import me.gavin.mimeware.mimeware.module.Category;
import me.gavin.mimeware.mimeware.module.Module;

public class FullbrightMod extends Module {
    public FullbrightMod() {
        super("Fullbright", Category.Render);
    }

    public void onEnable() {
        mc.gameSettings.gammaSetting = 100;
    }

    public void onDisable() {
        mc.gameSettings.gammaSetting = 1;
    }
}
