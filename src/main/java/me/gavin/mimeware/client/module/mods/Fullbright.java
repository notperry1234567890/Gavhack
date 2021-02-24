package me.gavin.mimeware.client.module.mods;

import me.gavin.mimeware.client.module.Category;
import me.gavin.mimeware.client.module.Module;

public class Fullbright extends Module {
    public Fullbright() {
        super("Fullbright", Category.Render);
    }

    public void onEnable() {
        mc.gameSettings.gammaSetting = 100;
    }

    public void onDisable() {
        mc.gameSettings.gammaSetting = 1;
    }
}
