package me.gavin.mimeware.mimeware.module.mods;

import me.gavin.mimeware.mimeware.events.PlayerChatEvent;
import me.gavin.mimeware.mimeware.module.Category;
import me.gavin.mimeware.mimeware.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import org.apache.commons.lang3.StringEscapeUtils;

public class ChatSuffixMod extends Module {
    public ChatSuffixMod() {
        super("ChatSuffix", Category.Misc);
    }

    String suffix = StringEscapeUtils.unescapeCsv(" \uff5c \u1d0d\u026a\u1d0d\u1d07\u1d21\u1d00\u0280\u1d07");

    @EventHandler
    private Listener<PlayerChatEvent.Post> chatListener = new Listener<>(event -> {
        if (event.getMessage().startsWith("/") || event.getMessage().startsWith(String.valueOf(mimeware.commandManager.prefix)))
            return;

        event.setMessage(event.getOriginalMessage().concat(suffix));
    });
}
