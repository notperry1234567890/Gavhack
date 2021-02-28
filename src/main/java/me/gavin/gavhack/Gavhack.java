package me.gavin.gavhack;

import me.gavin.gavhack.client.command.CommandManager;
import me.gavin.gavhack.client.misc.CapeUtil;
import me.gavin.gavhack.client.misc.EventProcessor;
import me.gavin.gavhack.client.misc.font.CFontManager;
import me.gavin.gavhack.client.misc.font.CFontRenderer;
import me.gavin.gavhack.client.module.ModuleManager;
import me.gavin.gavhack.client.ui.gui.GuiHackManager;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Gavhack.MODID, name = Gavhack.NAME, version = Gavhack.VERSION)
public class Gavhack {
    public static final String MODID = "gavhack";
    public static final String NAME = "Gavhack";
    public static final String VERSION = "1.0";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    public static EventBus EVENT_BUS;
    public static CFontRenderer cfont;
    public static ModuleManager modManager;
    public static CommandManager commandManager;
    public static GuiHackManager gui;
    public static CapeUtil capeUtil;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        EVENT_BUS = new EventManager();
        log("Event bus initialized");
        new EventProcessor();
        log("Event processor initialized");
        cfont = new CFontRenderer(CFontManager.CUSTOM_FONT, true,  true);
        log("Custom font renderer initialized");
        modManager = new ModuleManager();
        log("Module manager initialized");
        commandManager = new CommandManager();
        log("Command manager initialized");
        gui = new GuiHackManager();
        log("Click GUI initialized");
        capeUtil = new CapeUtil();
        log("Cape util initialized");

        log("Gavhack finished initialization");
    }

    public static void log(String info) {
        logger.info(info);
    }
}
