package me.gavin.mimeware.mimeware.events;

import me.zero.alpine.type.Cancellable;

public class PlayerChatEvent extends Cancellable {

    private final String originalMSG;
    private String message;

    public PlayerChatEvent(String message) {
        this.originalMSG = message;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getOriginalMessage() {
        return this.originalMSG;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
