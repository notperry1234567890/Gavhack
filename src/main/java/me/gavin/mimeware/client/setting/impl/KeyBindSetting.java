package me.gavin.mimeware.client.setting.impl;

/*
 * Written by @SrgantMooMoo on 11/17/20.
 */

import me.gavin.mimeware.client.module.Module;
import me.gavin.mimeware.client.setting.Setting;

public class KeyBindSetting extends Setting {
    public int code;

    public KeyBindSetting(int code, Module parent) {
        this.name = "KeyBind";
        this.code = code;
        this.parent = parent;
    }

    public int getKeyCode() {
        return this.code;
    }

    public void setKeyCode(int code) {
        this.code = code;
    }
}