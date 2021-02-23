package me.gavin.mimeware.mimeware.events;

public class KeyPressEvent {

    private final int key;

    public KeyPressEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return this.key;
    }
}
