package city.Animation;

import city.Start.BattleCity;

public class TileExplosion extends Effects {
	private float size;
	private static int delay = BattleCity.jsonObject.getJSONObject("Animation").getInt("Speed");
	
	public TileExplosion(float X, float Y, float size){
		super(X, Y, delay, AnimationList.TileExplosion);
		this.X = X;
		this.Y = Y;
		this.size = size;
	}

}
