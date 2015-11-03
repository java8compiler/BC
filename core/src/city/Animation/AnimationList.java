package city.Animation;

import city.Loaders.TextureLoader;

public class AnimationList {
    public static Frames TileExplosion;
    public static Frames BigExplosion;

    public AnimationList(){
        TileExplosion = new Frames(TextureLoader.exp_1_tile, TextureLoader.exp_2_tile, TextureLoader.exp_3_tile);
        BigExplosion = new Frames(TextureLoader.big_exp_1, TextureLoader.big_exp_2);
    }
}
