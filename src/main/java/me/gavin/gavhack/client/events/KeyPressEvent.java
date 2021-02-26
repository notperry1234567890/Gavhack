package me.gavin.gavhack.client.events;

public class KeyPressEvent {

    private final int key;

    public KeyPressEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return this.key;
    }
}