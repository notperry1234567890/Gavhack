package me.gavin.mimeware.mimeware.command;

import me.gavin.mimeware.Mimeware;
import me.gavin.mimeware.mimeware.command.commands.ExampleCMD;
import me.gavin.mimeware.mimeware.events.PlayerChatEvent;
import me.gavin.mimeware.mimeware.misc.Utils;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandManager {

    Minecraft mc = Minecraft.getMinecraft();
    Mimeware mimeware = Mimeware.getMimeware();

    public CommandManager() {
        mimeware.EVENT_BUS.subscribe(this);
        init();
    }

    ArrayList<CommandBase> commands = new ArrayList<>();

    private void init() {
        add(new ExampleCMD());
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
}
