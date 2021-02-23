package me.gavin.mimeware.mimeware.misc;

import club.minnced.discord.rpc.*;
import net.minecraft.client.gui.Gui;

public class DiscordHandler {

    DiscordRPC lib = DiscordRPC.INSTANCE;

    public DiscordHandler() {
        String applicationId = "813547015031619585";
        String steamId = "";
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> System.out.println("Ready!");
        lib.Discord_Initialize(applicationId, handlers, true, steamId);
        DiscordRichPresence presence = new DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
        presence.details = "howdy";
        lib.Discord_UpdatePresence(presence);
        // in a worker thread
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        }, "RPC-Callback-Handler").start();
    }

    public void stopRPC() {
        lib.Discord_Shutdown();
        lib.Discord_ClearPresence();
    }
}
