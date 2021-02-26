package me.gavin.gavhack.client.ui.gui.components;

import me.gavin.gavhack.Gavhack;
import me.gavin.gavhack.client.misc.Utils;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.ModeSetting;
import me.gavin.gavhack.client.ui.gui.Component;
import net.minecraft.client.gui.Gui;

import java.awt.*;

public class ModeComponent extends Component {

    public ModeSetting setting;

    public ModeComponent(Module parent, ModeSetting setting, int x, int y, int width, int height, int offset) {
        super(parent, x, y, width, height, offset);
        this.setting = setting;
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isMouseWithin(mouseX, mouseY)) {
            Utils.playClick();
            ((ModeSetting)parent.getSetting(setting.name)).cycle();
        }
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        if (isMouseWithin(mouseX, mouseY)) {
            Gui.drawRect(x, y, x + width, y + height, 0xcfcccccc);
        } else {
            Gui.drawRect(x, y, x + width, y + height, 0xcf000000);
        }

        Gavhack.cfont.drawStringWithShadow(setting.name + ": " + setting.getMode(), x + 3, y + 3, new Color(-1));
    }
}
