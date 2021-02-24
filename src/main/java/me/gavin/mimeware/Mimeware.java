package me.gavin.mimeware;

import me.gavin.mimeware.client.command.CommandManager;
import me.gavin.mimeware.client.gui.clickgui.GuiHackManager;
import me.gavin.mimeware.client.misc.EventProcessor;
import me.gavin.mimeware.client.misc.font.CFontManager;
import me.gavin.mimeware.client.misc.font.CFontRenderer;
import me.gavin.mimeware.client.module.ModuleManager;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = Mimeware.MOD_ID,
        name = Mimeware.MOD_NAME,
        version = Mimeware.VERSION
)
public class Mimeware {

    public static final String MOD_ID = "mimeware";
    public static final String MOD_NAME = "Mimeware";
    public static final String VERSION = "1.0";

    @Mod.Instance(MOD_ID)
    public static Mimeware INSTANCE;

    public static Mimeware getMimeware() {
        return INSTANCE;
    }

    public EventBus EVENT_BUS;
    public CFontRenderer font;
    public CommandManager commandManager;
    public ModuleManager modManager;
    public EventProcessor eventProcessor;
    public GuiHackManager clickGui;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // alpine event api
        EVENT_BUS = new EventManager();
        // process events
        eventProcessor = new EventProcessor();
        // mod manager
        modManager = new ModuleManager();
        // custom font
        font = new CFontRenderer(CFontManager.UBUNTU_FONT, true, true);
        // setup commands
        commandManager = new CommandManager();
        // gui
        clickGui = new GuiHackManager();
    }
}
