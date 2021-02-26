package me.gavin.gavhack.client.ui.gui.components;

import me.gavin.gavhack.Gavhack;
import me.gavin.gavhack.client.misc.Utils;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.ui.gui.Component;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public class KeybindComponent extends Component {

    public boolean listeningForKey;

    public KeybindComponent(Module parent, int x, int y, int width, int height, int offset) {
        super(parent, x, y, width, height, offset);
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        if (isMouseWithin(mouseX, mouseY)) {
            Gui.drawRect(x, y, x + width, y + height, 0xcfcccccc);
        } else {
            Gui.drawRect(x, y, x + width, y + height, 0xcf000000);
        }

        if (listeningForKey) {
            Gavhack.cfont.drawStringWithShadow("Listening...", x + 3, y + 3, new Color(-1));
        } else {
            Gavhack.cfont.drawStringWithShadow("Bind: " + Keyboard.getKeyName(parent.keyBind.getKeyCode()), x + 3 , y + 3, new Color(-1));
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (isMouseWithin(mouseX, mouseY)) {
            Utils.playClick();
            listeningForKey = !listeningForKey;
        }
    }

    @Override
    public void keyTyped(char keyChar, int keyCode) {
        if (listeningForKey) {
            Utils.playClick();
            if (keyCode == Keyboard.KEY_DELETE || keyCode == Keyboard.KEY_BACK) {
                parent.keyBind.setKeyCode(0);
            } else {
                parent.keyBind.setKeyCode(keyCode);
            }
            listeningForKey = false;
        }
    }
}
