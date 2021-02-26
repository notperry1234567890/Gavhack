package me.gavin.gavhack.client.ui.gui;

import me.gavin.gavhack.Gavhack;
import me.gavin.gavhack.client.misc.Utils;
import me.gavin.gavhack.client.module.Category;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class GuiHackManager extends GuiScreen {

    List<Panel> panels = new ArrayList<>();

    public GuiHackManager() {
        int offset = 0;
        for (Category c : Category.values()) {
            panels.add(new Panel(Gavhack.modManager.getModsByCategory(c), c, 20 + offset, 20, 90, 14));
            offset += 120;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        panels.forEach(panel -> {
            panel.updatePosition(mouseX, mouseY);
            panel.draw(mouseX, mouseY);
        });
    }

    @Override
    public boolean doesGuiPauseGame() { return false; }

    @Override
    public void keyTyped(char typedChar, int keyCode) {
        if (keyCode == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(null);
            Gavhack.modManager.getMod("ClickGUI").disable();
        }

        panels.forEach(panel -> panel.keyTyped(typedChar, keyCode));
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
            panels.forEach(panel -> {
                if (mouseButton == 1) {
                    if (panel.isMouseWithinHeader(mouseX, mouseY)) {
                        panel.toggleOpen();
                        Utils.playClick();
                    }
                }

                if (mouseButton == 0) {
                    if (panel.isMouseWithinHeader(mouseX, mouseY)) {
                        panel.dragging = true;
                        panel.dragX = mouseX - panel.x;
                        panel.dragY = mouseY - panel.y;
                    }
                }

                if (panel.open)
                    panel.buttons.forEach(modButton -> modButton.mouseClicked(mouseX, mouseY, mouseButton));
            });
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        panels.forEach(panel -> panel.dragging = false);
    }
}