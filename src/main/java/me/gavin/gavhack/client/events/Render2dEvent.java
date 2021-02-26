package me.gavin.gavhack.client.events;

import net.minecraft.client.gui.ScaledResolution;

public class Render2dEvent {
    private final ScaledResolution sr;

    public Render2dEvent(ScaledResolution sr) {
        this.sr = sr;
    }

    public ScaledResolution getScaledRes() {
        return this.sr;
    }
}