package city.Animation;

import city.Loaders.TextureLoader;
import city.Pos;
import city.World;

public class BigExplosion extends Effects {
    private byte size;

    public BigExplosion(float X, float Y, byte size){
        super(X-8, Y-6, 50, TextureLoader.big_exp_1, TextureLoader.big_exp_2);
        this.size = size;
    }

    public void update(World world){
        Pos pos = new Pos(X, Y);
        pos.TilePos();
        world.DeleteTiles(pos, size);
    }
}
