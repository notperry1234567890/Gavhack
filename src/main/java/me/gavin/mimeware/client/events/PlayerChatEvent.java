package me.gavin.mimeware.client.events;

import me.zero.alpine.type.Cancellable;

public class PlayerChatEvent extends Cancellable {

    public static class Pre extends PlayerChatEvent {
        private final String originalMSG;
        private String message;

        public Pre(String message) {
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

    public static class Post extends PlayerChatEvent {
        private final String originalMSG;
        private String message;

        public Post(String message) {
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
}
