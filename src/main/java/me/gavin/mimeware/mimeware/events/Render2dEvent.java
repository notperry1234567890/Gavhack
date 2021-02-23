package me.gavin.mimeware.mimeware.events;

import me.zero.alpine.type.Cancellable;
import net.minecraft.client.gui.ScaledResolution;

public class Render2dEvent extends Cancellable {

    private final ScaledResolution sr;

    public Render2dEvent(ScaledResolution sr) {
        this.sr = sr;
    }

    public ScaledResolution getScaledRes() {
        return this.sr;
    }
}
