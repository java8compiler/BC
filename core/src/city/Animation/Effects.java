package city.Animation;

import city.World.World;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Effects extends Animation {
	public float X,Y;
	
	public Effects(float X, float Y, long period, Frames frames){
		super(frames, period);
		this.X = X;
		this.Y = Y;
	}
	
	public void update(World world){
		super.update();
	}

	public void draw(SpriteBatch batch){
		frames.now().setPosition(X, Y);
		frames.now().draw(batch);
	}

	@Override
	protected void Stage() {
		if(frames.getFrame() > 0){
			float x = frames.now().getWidth()-frames.getSpriteToFrame(frames.getFrame()-1).getWidth();
			float y = frames.now().getHeight()-frames.getSpriteToFrame(frames.getFrame()-1).getHeight();
			X -= x/2;
			Y -= y/2;
		}
	}
}
