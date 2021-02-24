package me.gavin.mimeware.client.setting.impl;

/*
 * Written by @SrgantMooMoo on 11/17/20.
 */

import me.gavin.mimeware.client.module.Module;
import me.gavin.mimeware.client.setting.Setting;

public class BooleanSetting extends Setting {
    public boolean enabled;

    public BooleanSetting(String name, Module parent, boolean enabled) {
        this.name = name;
        this.parent = parent;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        //if(Main.saveLoad != null) {
        //    Main.saveLoad.save();
        //}
    }

    public void toggle() {
        this.enabled = !this.enabled;

        //if(Main.saveLoad != null) {
        //    Main.saveLoad.save();
        //}
    }

}