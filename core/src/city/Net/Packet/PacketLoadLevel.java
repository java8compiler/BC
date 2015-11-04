package city.Net.Packet;

public class PacketLoadLevel extends Packet {
    public  byte[] bytes;

    public PacketLoadLevel(byte[] bytes) {
        super((byte) 1);
    }
}
