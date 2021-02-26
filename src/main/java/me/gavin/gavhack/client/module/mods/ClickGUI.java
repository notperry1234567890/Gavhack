package me.gavin.gavhack.client.module.mods;

import me.gavin.gavhack.Gavhack;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {
    public ClickGUI() {
        super("ClickGUI", Category.Misc);
        keyBind.setKeyCode(Keyboard.KEY_RCONTROL);
    }

    public void onEnable() {
        mc.displayGuiScreen(Gavhack.gui);
    }
}
