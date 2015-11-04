package city.Net;

import city.Net.Packet.Packet;
import city.Net.Packet.PacketKey;

import java.io.OutputStream;
import java.nio.ByteBuffer;

public class PacketManager {
    public static void SendPacket(OutputStream out,Packet packet){
        try{
            if (packet instanceof PacketKey){
                PacketKey key = (PacketKey)packet;
                out.write(packet.id);
                out.write(key.state);
                out.write(getBytes(key.keycode));
            }
            out.flush();
        }catch (Exception e){}
    }

    public static int getInt(byte[] bytes){
        int INT = 0;
        if(bytes.length == 4){
            int p = 3;
            for (int i = 0; i < 4; i++){
                INT += bytes[i]*Math.pow(256, p);
                p--;
            }
        }
        return INT;
    }

    public static byte[] getBytes(int n){
        return ByteBuffer.allocate(4).putInt(n).array();
    }
}
