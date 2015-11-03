package city.Animation;

import city.World;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Effects extends Animation {
	public float X,Y;
	private Sprite[] sprites;
	
	public Effects(float X, float Y, long period, Sprite... sprites){
		super(period, sprites.length);
		this.X = X;
		this.Y = Y;
		if(sprites.length == 0){
			throw new ArrayStoreException("Sprites null");
		}
		this.sprites = sprites;
	}
	
	public void update(World world){
		super.update();
	}

	public void draw(SpriteBatch batch){
		sprites[stage].setPosition(X, Y);
		sprites[stage].draw(batch);
	}

	@Override
	protected void Stage() {
		if(stage > 0){
			float x = sprites[stage].getWidth()-sprites[stage-1].getWidth();
			float y = sprites[stage].getHeight()-sprites[stage-1].getHeight();
			X -= x/2;
			Y -= y/2;
		}
	}
}
