package me.gavin.gavhack.client.module.mods;

import me.gavin.gavhack.Gavhack;
import me.gavin.gavhack.client.events.PlayerChatEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketChatMessage;
import org.apache.commons.lang3.StringEscapeUtils;

public class ChatSuffix extends Module {
    public ChatSuffix() {
        super("ChatSuffix", Category.Misc);
    }

    String suffix = StringEscapeUtils.unescapeCsv(" \uff5c \u1d33\u1d43\u1d5b\u02b0\u1d43\u1d9c\u1d4f");

    @EventHandler
    private Listener<PlayerChatEvent.Post> chatListener = new Listener<>(event -> {
        if (event.getMessage().startsWith("/") || event.getMessage().startsWith(String.valueOf(Gavhack.commandManager.prefix)))
            return;

        event.cancel();

        // done to make sure the suffix is not added onto your message
        // history when you press the up arrow in the chat gui
        mc.getConnection().sendPacket(new CPacketChatMessage(event.getOriginalMessage().concat(suffix)));
        mc.ingameGUI.getChatGUI().addToSentMessages(event.getOriginalMessage());
    });
}