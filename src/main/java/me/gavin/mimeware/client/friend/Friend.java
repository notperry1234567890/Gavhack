package me.gavin.mimeware.client.friend;

public class Friend {

    private String uuid, name;

    public Friend(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getUuid() {
        return this.uuid;
    }
}
