package city.Net;


import city.Exception.WorldNegativeSizeException;
import city.Screens.GameContainer;
import city.Screens.NetScreen;
import city.Tiles.Tile;
import city.World.Player;
import city.World.World;

public class NetworkWorld extends World {
    private NetworkPlayer player;
    private Connection connection;
    private NetScreen netScreen;

    public NetworkWorld(int sizeX, int sizeY, Connection connection, NetScreen netScreen) throws Exception{
        super(sizeX, sizeY, null, true);
        this.connection = connection;
        this.netScreen = netScreen;
    }

    @Override
    public void loadWorld(byte[] bytes) {
        super.loadWorld(bytes);
    }

    @Override
    public void update() throws Exception {
        for (int i = 0; i < getBulletList().size(); i++){
            getBulletList().get(i).update(this, netScreen.effectsRenderer);
        }
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}
