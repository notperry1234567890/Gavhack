package me.gavin.mimeware.client.gui.clickgui;

import me.gavin.mimeware.Mimeware;
import me.gavin.mimeware.client.misc.Utils;
import me.gavin.mimeware.client.module.Category;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class GuiHackManager extends GuiScreen {

    List<Panel> panels = new ArrayList<>();
    Mimeware mimeware = Mimeware.getMimeware();

    public GuiHackManager() {
        int offset = 0;
        for (Category c : Category.values()) {
            panels.add(new Panel(mimeware.modManager.getModsByCategory(c), c, 20 + offset, 20, 90, 14));
            offset += 120;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        panels.forEach(panel -> panel.draw(mouseX, mouseY));
    }

    @Override
    public boolean doesGuiPauseGame() { return false; }

    @Override
    public void keyTyped(char typedChar, int keyCode) {
        if (keyCode == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(null);
            mimeware.modManager.getMod("ClickGUI").disable();
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 1) {
            panels.forEach(panel -> {
                if (panel.isMouseWithinHeader(mouseX, mouseY)) {
                    panel.toggleOpen();
                    Utils.playClick();
                }
            });
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) { }
}
