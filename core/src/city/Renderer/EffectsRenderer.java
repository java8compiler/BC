package city.Renderer;

import java.util.ArrayList;

import city.Animation.BigExplosion;
import city.Animation.Effects;
import city.Animation.TileExplosion;
import city.Screens.GameContainer;
import city.World.World;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EffectsRenderer {
	private ArrayList<Effects> effects;
	
	public EffectsRenderer(){
		effects = new ArrayList<Effects>();
	}
	
	public void renderer(SpriteBatch batch){
		for(int i = 0;i<effects.size();i++){
			effects.get(i).draw(batch);
		}
	}
	
	public void update(World world){
		for(int i = 0;i<effects.size();i++){
			effects.get(i).update(world);
			if(!effects.get(i).Live) effects.remove(i);
		}
	}
	
	public void addEffects(String name, float x, float y){
		Effects e = null;
		switch(name){
			case "te": e = new TileExplosion(x, y, 0); break;
			case"be_3": e = new BigExplosion(x, y, (byte) 3); break;
			case"be_6": e = new BigExplosion(x, y, (byte) 6); break;
		}
		if(e != null){
			effects.add(e);
		}
	}
}
