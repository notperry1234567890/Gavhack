package me.gavin.mimeware.client.module.mods;

import me.gavin.mimeware.client.events.KeyPressEvent;
import me.gavin.mimeware.client.events.LocalTickEvent;
import me.gavin.mimeware.client.module.Category;
import me.gavin.mimeware.client.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {

    public ClickGUI() {
        super("ClickGUI", Category.Misc);
        keyBind.setKeyCode(Keyboard.KEY_RSHIFT);
    }

    public void onEnable() {
        mc.displayGuiScreen(mimeware.clickGui);
    }
}
