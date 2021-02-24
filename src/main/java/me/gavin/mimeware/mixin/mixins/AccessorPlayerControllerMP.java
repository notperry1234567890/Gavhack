package me.gavin.mimeware.mixin.mixins;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerControllerMP.class)
public interface AccessorPlayerControllerMP {

    @Accessor("isHittingBlock")
    void setIsHittingBlock(boolean value);

    @Accessor("blockHitDelay")
    int getBlockHitDelay();

    @Accessor("blockHitDelay")
    void setBlockHitDelay(int value);

    @Accessor("currentPlayerItem")
    int getCurrentPlayerItem();
}
