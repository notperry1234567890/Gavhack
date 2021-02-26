package me.gavin.gavhack.client.ui.gui;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gavin.gavhack.Gavhack;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import net.minecraft.client.gui.Gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel {

    public int x, y, dragX, dragY, width, height;
    private Category category;
    public boolean open, dragging;

    public List<ModuleButton> buttons = new ArrayList<>();

    public Panel(List<Module> modules, Category category, int x, int y, int width, int height) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        int yOffset = 0;
        for (Module m : modules) {
            buttons.add(new ModuleButton(m, this, x, y + height + yOffset, 90, 14, yOffset));
            yOffset += 14;
        }
    }

    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        buttons.forEach(moduleButton -> moduleButton.mouseReleased(mouseX, mouseY, mouseButton));
    }

    public void updatePosition(int mouseX, int mouseY) {
        if (this.dragging) {
            this.x = (mouseX - dragX);
            this.y = (mouseY - dragY);
        }
    }

    public void draw(int mouseX, int mouseY) {
        Gui.drawRect(x, y, x + width, y + height, 0xfcff0000);
        Gavhack.cfont.drawStringWithShadow(ChatFormatting.BOLD + category.toString() + " (" + buttons.size() + ")", x + 3, y + 3, new Color(-1));

        if (open)
            buttons.forEach(moduleButton -> {
                moduleButton.setPos(x, y + height + moduleButton.offset);
                moduleButton.draw(mouseX, mouseY);
            });
    }

    public boolean isMouseWithinHeader(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }

    public void toggleOpen() {
        this.open = !this.open;
    }

    public void keyTyped(char keyChar, int keyCode) {
        buttons.forEach(moduleButton -> moduleButton.keyTyped(keyChar, keyCode));
    }
}