package me.gavin.gavhack.client.module;

import me.gavin.gavhack.Gavhack;
import me.gavin.gavhack.client.setting.Setting;
import me.gavin.gavhack.client.setting.impl.KeyBindSetting;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Module {

    public KeyBindSetting keyBind = new KeyBindSetting(Keyboard.KEY_NONE, this);

    protected Minecraft mc = Minecraft.getMinecraft();

    boolean enabled;
    String name;
    Category category;

    public ArrayList<Setting> settings = new ArrayList<>();

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
        addSettings(keyBind);
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
        Gavhack.EVENT_BUS.subscribe(this);
    }

    public void disable() {
        enabled = false;
        onDisable();
        Gavhack.EVENT_BUS.unsubscribe(this);
    }

    public void onEnable() {}

    public void onDisable() {}
}