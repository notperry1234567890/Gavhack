package me.gavin.mimeware.client.module;

import me.gavin.mimeware.Mimeware;
import me.gavin.mimeware.client.setting.Setting;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Module {

    protected Minecraft mc = Minecraft.getMinecraft();
    protected Mimeware mimeware = Mimeware.getMimeware();

    boolean enabled;
    String name;
    Category category;

    ArrayList<Setting> settings = new ArrayList<>();

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public void addSettings(Setting... newSettings) {
        settings.addAll(Arrays.asList(newSettings));
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

    public void onEnable() {}

    public void onDisable() {}
}
