package city.Net;

import city.Net.Packet.Packet;
import city.Net.Packet.PacketLoadLevel;
import city.Net.Packet.PacketSetPlayerCoords;
import city.Net.Packet.PacketYouId;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Stack;

public class Connection extends Thread {
    private boolean status;
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private Stack<Packet> packetStack;

    public Connection(Socket socket) throws Exception{
        status = true;
        this.socket = socket;
        in = socket.getInputStream();
        out = socket.getOutputStream();
        socket.setReceiveBufferSize(64 * 1024);
        socket.setSendBufferSize(64 * 1024);
        packetStack = new Stack<Packet>();
    }

    public void run(){
        while (status){
            try{
                if(in.available() > 0){
                    int id = in.read();
                    if(id == 0){
                        System.out.println("Status="+status);
                    }
                    if(id == 1){
                        int len = in.read();
                        byte[] bytes = new byte[len];
                        in.read(bytes);
                        push(new PacketLoadLevel(bytes));
                    }
                    if (id == 2){
                        int PlayerId = in.read();
                        byte[] bytes = new byte[4];
                        in.read(bytes);
                        int X = getInt(bytes);
                        in.read(bytes);
                        int Y = getInt(bytes);
                        push(new PacketSetPlayerCoords((byte) PlayerId, X, Y));
                    }
                    if (id == 3){
                        int youId = in.read();
                        push(new PacketYouId((byte)youId));
                    }
                }
            }catch (Exception e){}
            yield();
        }
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

    public synchronized void push(Packet packet){
        packetStack.push(packet);
    }

    public synchronized Packet pull(){
        if(!packetStack.empty()){
            return packetStack.pop();
        }
        return null;
    }
}
