package me.gavin.mimeware.client.friend;

import java.util.ArrayList;

public class FriendManager {

    private ArrayList<Friend> friendList;

    public FriendManager() {
        friendList = new ArrayList<>();
    }

    public void addFriend(Friend friendIn) {
        friendList.add(friendIn);
    }

    public void removeFriend(Friend friendIn) {
        friendList.remove(friendIn);
    }

    public ArrayList<Friend> getFriendList() {
        return this.friendList;
    }

    public Friend getFriendByName(String name) {
        return friendList.stream().filter(friend -> friend.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
