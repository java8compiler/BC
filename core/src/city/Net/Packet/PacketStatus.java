package city.Net.Packet;

public class PacketStatus extends Packet{
    public byte status;

    public PacketStatus(byte status) {
        super((byte) 4);
        this.status = status;
    }
}
