package me.gavin.mimeware.client.misc.font;

import java.awt.*;

public class CFontManager {

    public static Font UBUNTU_FONT = getFontByName("ubuntu").deriveFont(18f);

    public static Font getFontByName(String name) {
        if (name.equalsIgnoreCase("ubuntu")) {
            return getFontFromInput("/assets/mimeware/Ubuntu.ttf");
        }
        return null;
    }

    public static Font getFontFromInput(String path) {

        try {
            Font newFont = Font.createFont(Font.TRUETYPE_FONT, CFontManager.class.getResourceAsStream(path));
            return newFont;
        }
        catch (Exception e) {
            return null;
        }
    }
}