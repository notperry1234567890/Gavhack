package me.gavin.mimeware.mimeware.command;

import me.gavin.mimeware.Mimeware;
import me.gavin.mimeware.mimeware.command.commands.ToggleCMD;
import me.gavin.mimeware.mimeware.events.KeyPressEvent;
import me.gavin.mimeware.mimeware.events.PlayerChatEvent;
import me.gavin.mimeware.mimeware.misc.Utils;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiNewChat;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Arrays;

// made partly by following the command tutorial from "intent store" on youtube
// because i have never made a command system before :)
public class CommandManager {

    Minecraft mc = Minecraft.getMinecraft();
    Mimeware mimeware = Mimeware.getMimeware();

    public CommandManager() {
        mimeware.EVENT_BUS.subscribe(this);
        init();
    }

    ArrayList<CommandBase> commands = new ArrayList<>();

    private void init() {
        add(new ToggleCMD());
    }

    private void add(CommandBase command) {
        commands.add(command);
    }

    public char prefix = '.';

    // listening for chat events
    @EventHandler
    private Listener<PlayerChatEvent> chatListener = new Listener<>(event -> {
        String message = event.getMessage();
        if (message.startsWith(String.valueOf(prefix))) {
            event.cancel();
            // command logic
            mc.ingameGUI.getChatGUI().addToSentMessages(message);

            // just some experimental stuff
            //mc.ingameGUI.getChatGUI().getSentMessages().remove(0);

            if (message.length() == 1) {
                Utils.printMSG("You must specify a command");
                return;
            }

            message = message.substring(1);

            if (message.split(" ").length > 0) {
                String cmdName = message.split(" ")[0];
                for (CommandBase c : commands) {
                    if (c.getAliases().contains(cmdName) ||c.getName().equalsIgnoreCase(cmdName)) {
                        c.onCommand(Arrays.copyOfRange(message.split(" "), 1, message.split(" ").length), message);
                        return;
                    }
                }
                Utils.printMSG("Command not found, type " + prefix + "list for a list of commands");
            } else {
                Utils.printMSG("Invalid command syntax");
            }
        }
    });

    @EventHandler
    private Listener<KeyPressEvent> keyListener = new Listener<>(event -> {
        if (event.getKey() == Keyboard.getKeyIndex(String.valueOf(prefix))) {
            mc.displayGuiScreen(new GuiChat(String.valueOf(prefix)));
        }
    });
}
