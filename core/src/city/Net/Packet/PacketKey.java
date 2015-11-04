package city.Net.Packet;

public class PacketKey extends Packet{
    public byte state;
    public int keycode;

    public PacketKey(byte state, int keycode) {
        super((byte) 5);
        this.state = state;
        this.keycode = keycode;
    }
}
