package me.gavin.mimeware.mixin.mixins;

import me.gavin.mimeware.Mimeware;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Redirect(method = "createDisplay", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Display;setTitle(Ljava/lang/String;)V"))
    private void ovverideMakeDisplay(String newTitle) {
        Display.setTitle(Mimeware.MOD_NAME + " " + Mimeware.VERSION);
    }
}
