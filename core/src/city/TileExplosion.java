package city;

import city.Loaders.TextureLoader;

public class TileExplosion extends Effects {
	private float size;
	private static int delay = BattleCity.jsonObject.getJSONObject("Animation").getInt("Speed");
	
	public TileExplosion(float X, float Y, float size){
		super(X, Y, delay, TextureLoader.exp_1_tile, TextureLoader.exp_2_tile, TextureLoader.exp_3_tile);
		this.X = X;
		this.Y = Y;
		this.size = size;
	}

}
