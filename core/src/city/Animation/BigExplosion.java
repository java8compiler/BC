package city.Animation;

import city.Utils.Pos;
import city.World.World;

public class BigExplosion extends Effects {
    private byte size;

    public BigExplosion(float X, float Y, byte size){
        super(X-8, Y-6, 50, AnimationList.BigExplosion);
        this.size = size;
    }

    public void update(World world){
        Pos pos = new Pos(X, Y);
        pos.TilePos();
        world.DeleteTiles(pos, size);
    }
}
