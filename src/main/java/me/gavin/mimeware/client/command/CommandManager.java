package me.gavin.mimeware.client.command;

import me.gavin.mimeware.Mimeware;
import me.gavin.mimeware.client.command.commands.*;
import me.gavin.mimeware.client.events.KeyPressEvent;
import me.gavin.mimeware.client.events.PlayerChatEvent;
import me.gavin.mimeware.client.misc.Utils;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
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
        add(new HelpCMD());
        add(new PrefixCMD());
    }

    private void add(CommandBase command) {
        commands.add(command);
    }

    public ArrayList<CommandBase> getCommands() {
        return commands;
    }

    public char prefix = '.';

    // listening for chat events
    @EventHandler
    private Listener<PlayerChatEvent.Pre> chatListener = new Listener<>(event -> {
        String message = event.getMessage();
        if (message.startsWith(String.valueOf(prefix))) {
            event.cancel();
            // command logic
            mc.ingameGUI.getChatGUI().addToSentMessages(message);

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
                Utils.printMSG("Command not found, type " + prefix + "help for a list of commands");
            } else {
                Utils.printMSG("Invalid command syntax");
            }
        }
    });

    @EventHandler
    private Listener<KeyPressEvent> keyListener = new Listener<>(event -> {
        if (prefix == Keyboard.getEventCharacter()) {
            mc.displayGuiScreen(new GuiChat(String.valueOf(prefix)));
        }
    });
}
