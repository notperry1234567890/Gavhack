package me.gavin.mimeware.mimeware.module.mods;

import me.gavin.mimeware.mimeware.events.PlayerChatEvent;
import me.gavin.mimeware.mimeware.module.Category;
import me.gavin.mimeware.mimeware.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketChatMessage;
import org.apache.commons.lang3.StringEscapeUtils;

public class ChatSuffixMod extends Module {
    public ChatSuffixMod() {
        super("ChatSuffix", Category.Misc);
    }

    String suffix = StringEscapeUtils.unescapeCsv(" \uff5c \u1d50\u2071\u1d50\u1d49\u02b7\u1d43\u02b3\u1d49");

    @EventHandler
    private Listener<PlayerChatEvent.Post> chatListener = new Listener<>(event -> {
        if (event.getMessage().startsWith("/") || event.getMessage().startsWith(String.valueOf(mimeware.commandManager.prefix)))
            return;

        event.cancel();

        // done to make sure the suffix is not added onto your message
        // history when you press the up arrow in the chat gui
        mc.getConnection().sendPacket(new CPacketChatMessage(event.getOriginalMessage().concat(suffix)));
        mc.ingameGUI.getChatGUI().addToSentMessages(event.getOriginalMessage());
    });
}
