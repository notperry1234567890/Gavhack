package me.gavin.mimeware;

import me.gavin.mimeware.mimeware.command.CommandManager;
import me.gavin.mimeware.mimeware.misc.DiscordHandler;
import me.gavin.mimeware.mimeware.misc.EventProcessor;
import me.gavin.mimeware.mimeware.misc.font.CFontManager;
import me.gavin.mimeware.mimeware.misc.font.CFontRenderer;
import me.gavin.mimeware.mimeware.module.ModuleManager;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Mimeware.MOD_ID, name = Mimeware.MOD_NAME, version = Mimeware.VERSION)
public class Mimeware {
    public static final String MOD_ID = "mimeware", MOD_NAME = "Mimeware", VERSION = "1.0";

    @Mod.Instance
    private static Mimeware INSTANCE;

    public static Mimeware getMimeware() {
        return Mimeware.INSTANCE;
    }

    public EventBus EVENT_BUS;
    public EventProcessor eventProcessor;
    public ModuleManager modManager;
    public DiscordHandler discordHandler;
    public CommandManager commandManager;
    public CFontRenderer font;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Alpine event api
        EVENT_BUS = new EventManager();
        // custom font
        font = new CFontRenderer(CFontManager.UBUNTU_FONT, true, true);
        // event processor
        eventProcessor = new EventProcessor();
        // discord rpc
        discordHandler = new DiscordHandler();
        // registering modules
        modManager = new ModuleManager();
        // registering commands
        commandManager = new CommandManager();
    }
}
