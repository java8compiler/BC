package city.Net.Packet;

public class PacketCreateEntity extends Packet {
    public int X, Y, dx, dy;
    public byte EntityId;

    public PacketCreateEntity(byte entityId, int x, int y, int dx, int dy) {
        super((byte) 6);
        this.EntityId = entityId;
        this.X = x;
        this.Y = y;
        this.dx = dx;
        this.dy = dy;
    }
}
