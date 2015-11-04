package city.Net.Packet;

public class PacketSetPlayerCoords extends Packet{
    public int X, Y;
    public byte direction;
    public byte PlayerId;

    public PacketSetPlayerCoords(byte PlayerId, byte direction,int X, int Y) {
        super((byte) 2);
        this.PlayerId = PlayerId;
        this.direction = direction;
        this.X = X;
        this.Y = Y;
    }
}
