package city.Net;

import city.Net.Packet.PacketKey;
import city.Screens.NetScreen;
import city.World.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.IOException;
import java.security.Key;

public class NetworkPlayer extends Player {
    private NetScreen netScreen;

    public NetworkPlayer(NetScreen netScreen, int x, int y){
        super(x, y, null);
        this.netScreen = netScreen;
    }

    public void update(){
            try {
                if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
                    PacketManager.SendPacket(netScreen.connection.socket.getOutputStream(), new PacketKey((byte) 1, Input.Keys.UP));
                }

                if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                    PacketManager.SendPacket(netScreen.connection.socket.getOutputStream(), new PacketKey((byte) 1, Input.Keys.DOWN));
                }

                if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    PacketManager.SendPacket(netScreen.connection.socket.getOutputStream(), new PacketKey((byte) 1, Input.Keys.LEFT));
                }

                if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    PacketManager.SendPacket(netScreen.connection.socket.getOutputStream(), new PacketKey((byte) 1, Input.Keys.RIGHT));
                }
            } catch (IOException e) {
                e.printStackTrace();
        }
    }
}
