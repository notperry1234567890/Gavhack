package me.gavin.mimeware.client.gui.clickgui;

import me.gavin.mimeware.Mimeware;
import me.gavin.mimeware.client.misc.Utils;
import me.gavin.mimeware.client.module.Category;
import me.gavin.mimeware.client.module.Module;
import net.minecraft.client.gui.Gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel {

    protected Mimeware mimeware = Mimeware.getMimeware();

    private int x, y, dragX, dragY, width, height;
    private Category category;
    private boolean open;

    private List<Module> modules;

    public Panel(List<Module> modules, Category category, int x, int y, int width, int height) {
        this.category = category;
        this.modules = modules;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(int mouseX, int mouseY) {
        Gui.drawRect(x, y, x + width, y + height, 0xcc000000);
        Utils.drawRainbowFont(category.toString() + " (" + modules.size() + ")", x + 3, y + 3);
    }

    public boolean isMouseWithinHeader(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }

    public void toggleOpen() {
        this.open = !this.open;
    }
}
