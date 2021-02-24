package me.gavin.mimeware.mixin.mixins;

import io.netty.channel.ChannelHandlerContext;
import me.gavin.mimeware.Mimeware;
import me.gavin.mimeware.client.events.PacketEvent;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {

    Mimeware mimeware = Mimeware.getMimeware();

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    public void onPacketSend(Packet<?> packet, CallbackInfo ci) {
        PacketEvent.Send packetEvent = new PacketEvent.Send(packet);
        mimeware.EVENT_BUS.post(packetEvent);
        if (packetEvent.isCancelled())
            ci.cancel();
    }

    @Inject(method = "channelRead0", at = @At("HEAD"), cancellable = true)
    public void onPacketRead(ChannelHandlerContext chc, Packet<?> packet, CallbackInfo ci) {
        PacketEvent.Receive packetEvent = new PacketEvent.Receive(packet);
        mimeware.EVENT_BUS.post(packetEvent);
        if (packetEvent.isCancelled())
            ci.cancel();
    }
}
