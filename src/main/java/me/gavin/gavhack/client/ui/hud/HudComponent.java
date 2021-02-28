package me.gavin.gavhack.client.ui.hud;

public abstract class HudComponent {

    public int x, y, width, height, dragX, dragY;

    public HudComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setWidth(int newWidth) {
        this.width = newWidth;
    }

    public void setHeight(int newHeight) {
        this.height = height;
    }

    public abstract void draw(int mouseX, int mouseY, int mouseButton);
}
