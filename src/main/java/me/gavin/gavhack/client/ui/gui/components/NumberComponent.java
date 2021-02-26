package me.gavin.gavhack.client.ui.gui.components;

import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.NumberSetting;
import me.gavin.gavhack.client.ui.gui.Component;

// code was referenced from past by olliem5 to do the sliders
public class NumberComponent extends Component {

    public NumberSetting setting;
    public double sliderWidth;

    public NumberComponent(Module parent, NumberSetting setting, int x, int y, int width, int height, int offset) {
        super(parent, x, y, width, height, offset);

        this.setting = setting;
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {

    }

    @Override
    public void draw(int mouseX, int mouseY) {

    }
}
