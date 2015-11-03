package city.World;

import city.Start.BattleCity;
import city.Renderer.EffectsRenderer;
import city.Tiles.Tile;

import city.Loaders.SoundLoader;
import city.Utils.Pos;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Bullet {
	Pos pos;
	Pos tilePos;
	float dx, dy;
	public static final float speed = BattleCity.jsonObject.getJSONObject("Bullet").getInt("Speed");
	public boolean Live = true;
	private int tileToLive = 0;
	
	public Bullet(Pos pos, float dx, float dy){
		this.pos = pos;
		this.dx = dx*speed;
		this.dy = dy*speed;
		tilePos = new Pos(pos.X, pos.Y);
		tilePos.TilePos();
	}
	
	public void update(World world, EffectsRenderer effectsRenderer){
		tileToLive++;
		if(tileToLive > 60*5) Live = false;
		pos.X+=dx;
		pos.Y+=dy;
		tilePos = new Pos(pos.X, pos.Y);
		tilePos.TilePos();
		if(world.getPlayer().getBound().contains(pos.X, pos.Y)){
			world.getPlayer().setDamage(1);
		}
		if(world.getTile(tilePos) != null && world.getTile(tilePos).isBulletCollision()){
			Tile tile = world.getTile(tilePos);
			SoundLoader.explosion.play(SoundLoader.Volume);
			effectsRenderer.addEffects("te", pos.X-6, pos.Y-6);
			if(tile.isKill()){
				world.setTile(new Tile((int)tilePos.X, (int)tilePos.Y, 0, false, false, false));
			}
			Live = false;
		}
	}
	
	public void draw(ShapeRenderer r){
		r.line(pos.X, pos.Y, pos.X+dx, pos.Y+dy);
	}
}
