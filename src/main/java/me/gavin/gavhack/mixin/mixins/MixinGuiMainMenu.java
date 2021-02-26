package me.gavin.gavhack.mixin.mixins;

import me.gavin.gavhack.Gavhack;
import me.gavin.gavhack.client.misc.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public class MixinGuiMainMenu {

    @Inject(method = "drawScreen", at = @At("TAIL"))
    private void drawScreenHook(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        Utils.drawRainbowFont(Gavhack.NAME + " " + Gavhack.VERSION, 2, 2);
    }
}
