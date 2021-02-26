package me.gavin.gavhack.client.ui.gui.components;

import me.gavin.gavhack.Gavhack;
import me.gavin.gavhack.client.misc.Utils;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import me.gavin.gavhack.client.ui.gui.Component;
import net.minecraft.client.gui.Gui;

import java.awt.*;

public class BooleanComponent extends Component {

    public BooleanSetting setting;

    public BooleanComponent(Module parent, BooleanSetting setting, int x, int y, int width, int height, int offset) {
        super(parent, x, y, width, height, offset);
        this.setting = setting;
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isMouseWithin(mouseX, mouseY)) {
            Utils.playClick();
            // gay code idc
            //setting.parent.
        }
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        if (isMouseWithin(mouseX, mouseY)) {
            Gui.drawRect(x, y, x + width, y + height, 0x90cccccc);
        } else {
            Gui.drawRect(x, y, x + width, y + height, 0x90000000);
        }

        if (setting.enabled) {
            Gavhack.cfont.drawStringWithShadow(setting.name, x + 3, y + 3, new Color(0xff0000));
        } else {
            Gavhack.cfont.drawStringWithShadow(setting.name, x + 3, y + 3, new Color(-1));
        }
    }
}
