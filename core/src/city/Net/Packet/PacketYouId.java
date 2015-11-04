package city.Net.Packet;

public class PacketYouId extends Packet {
    public byte id;

    public PacketYouId(byte id) {
        super((byte) 3);
        this.id = id;
    }
}
