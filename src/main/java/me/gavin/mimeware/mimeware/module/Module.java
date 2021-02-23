package me.gavin.mimeware.mimeware.module;

import me.gavin.mimeware.Mimeware;
import net.minecraft.client.Minecraft;

public abstract class Module {

    protected Minecraft mc = Minecraft.getMinecraft();
    protected Mimeware mimeware = Mimeware.getMimeware();

    boolean enabled;
    String name;
    Category category;

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public Category getCategory() {
        return this.category;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void toggle() {
        if (enabled) {
            disable();
        } else {
            enable();
        }
    }

    public void enable() {
        enabled = true;
        onEnable();
        mimeware.EVENT_BUS.subscribe(this);
    }

    public void disable() {
        enabled = false;
        onDisable();
        mimeware.EVENT_BUS.unsubscribe(this);
    }

    public void onEnable() {

    }

    public void onDisable() {

    }


}
