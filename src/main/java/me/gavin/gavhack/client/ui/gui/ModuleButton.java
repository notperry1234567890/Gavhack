package me.gavin.gavhack.client.ui.gui;

import me.gavin.gavhack.Gavhack;
import me.gavin.gavhack.client.misc.Utils;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.Setting;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import me.gavin.gavhack.client.ui.gui.components.BooleanComponent;
import me.gavin.gavhack.client.ui.gui.components.KeybindComponent;
import net.minecraft.client.gui.Gui;

import java.awt.*;
import java.util.ArrayList;

public class ModuleButton {

    public int x, y, width, height, offset;
    public Module module;
    public Panel panel;
    boolean open;

    ArrayList<Component> settingComponents = new ArrayList<>();

    public ModuleButton(Module module, Panel parent, int x, int y, int width, int height, int offset) {
        this.module = module;
        this.panel = parent;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.offset = offset;

        // had to make it -14 because everything was 14 lower than it should be
        int settingOffset = -14;
        for (Setting s : module.settings) {
            if (s instanceof BooleanSetting) {
                settingComponents.add(new BooleanComponent(module, (BooleanSetting) s, x + width, y + settingOffset, width, height, settingOffset));
            }

            settingOffset += 14;
        }

        settingComponents.add(new KeybindComponent(module, x + width, y + settingOffset, width, height, settingOffset));
    }

    public void draw(int mouseX, int mouseY) {
        if (isMouseWithin(mouseX, mouseY)) {
            Gui.drawRect(x, y, x + width, y + height, 0x90cccccc);
        } else {
            Gui.drawRect(x, y, x + width, y + height, 0x90000000);
        }

        int color = -1;

        if (module.isEnabled())
            color = 0xff0000;

        Gavhack.cfont.drawStringWithShadow(module.getName(), x + 3, y + 3, new Color(color));

        if (open)
            settingComponents.forEach(component -> {
                component.setPos(x + width, y + component.offset);
                component.draw(mouseX, mouseY);
            });
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isMouseWithin(mouseX, mouseY)) {
            Utils.playClick();
            if (mouseButton == 0) {
                module.toggle();
                Utils.playClick();
            }

            if (mouseButton == 1) {
                open = !open;
            }
        }
        if (open)
            settingComponents.forEach(component -> component.mouseClicked(mouseX, mouseY, mouseButton));
    }

    public void keyTyped(char keyChar, int keyCode) {
        if (open)
            settingComponents.forEach(component -> component.keyTyped(keyChar, keyCode));
    }

    public Module getModule() {
        return module;
    }

    public boolean isMouseWithin(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
