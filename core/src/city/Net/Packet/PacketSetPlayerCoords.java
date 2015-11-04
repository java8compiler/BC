package city.Net.Packet;

public class PacketSetPlayerCoords extends Packet{
    public int X, Y;
    public byte PlayerId;

    public PacketSetPlayerCoords(byte PlayerId,int X, int Y) {
        super((byte) 2);
        this.PlayerId = PlayerId;
        this.X = X;
        this.Y = Y;
    }
}
