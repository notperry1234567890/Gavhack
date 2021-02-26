package me.gavin.gavhack.client.ui.gui;

import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.Setting;

public abstract class Component {

    public int x, y, width, height, offset;
    public Module parent;

    public Component(Module parent , int x, int y, int width, int height, int offset) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.offset = offset;
        this.parent = parent;
    }

    public abstract void mouseClicked(int mouseX, int mouseY, int button);

    public void keyTyped(char keyChar, int keyCode) {

    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(int mouseX, int mouseY);

    public boolean isMouseWithin(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }
}
