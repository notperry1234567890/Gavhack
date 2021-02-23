package me.gavin.mimeware.mimeware.events;

import me.zero.alpine.type.Cancellable;
import net.minecraft.network.Packet;

public class PacketEvent extends Cancellable {

    public static class Send extends PacketEvent {
        private final Packet packet;

        public Send(Packet packetIn) {
            this.packet = packetIn;
        }

        public Packet getPacket() {
            return this.packet;
        }
    }

    public static class Receive extends PacketEvent {
        private final Packet packet;

        public Receive(Packet packetIn) {
            this.packet = packetIn;
        }

        public Packet getPacket() {
            return this.packet;
        }
    }
}
