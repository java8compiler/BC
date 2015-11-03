package city;

import city.Loaders.SoundLoader;
import city.Loaders.TextureLoader;
import city.Screens.GameContainer;
import city.Utils.Operation;
import city.Utils.Timer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {
	private GameContainer gc;
	public float X,Y;
	public static final float w = 10.5f;
	public byte direction = 0;
	public final float const_speed = BattleCity.jsonObject.getJSONObject("Tank").getInt("Speed");
	public float speed = const_speed;
	private int inTileY;
	private Pos lastPos;
	private static long timeToReload = 300;
	private float health = 5.5f;
	public float maxHealth = 5.5f;
	private Rectangle bound;
	private boolean isReload;
	
	public Player(int x, int y, GameContainer gc){
		this.gc = gc;
		X = x;
		Y = y;
		isReload = false;
		lastPos = new Pos(X, Y);
		bound = new Rectangle(X, Y, 13, 13);
	}
	
	public void update(){
		Collision(gc.world);
		bound.setPosition(X, Y);
	}
	
	public void Collision(World world){
		speed = const_speed;
		Pos pos1 = null, pos2 = null, pos3 = null, pos4 = null, pos5 = null, pos6 = null, pos7 = null, pos8 =null;
		lastPos.X = X;
		lastPos.Y = Y;
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {direction = 2; move();} else
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {direction = 0; move();} else
		if(Gdx.input.isKeyPressed(Keys.UP)) {direction = 1; move();}else
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {direction = 3; move();}
		if(Gdx.input.isKeyPressed(Keys.SPACE) && !isReload){
			boom();
			isReload = true;
			world.addTimer(new Timer(gc, timeToReload, new Operation() {
				@Override
				public void operation(GameContainer container) {
					container.world.getPlayer().isReload = false;
				}
			}));
		}
		gc.camera.position.set(X, Y, 0);
		
		pos1 = new Pos(X, Y); pos1.TilePos();
		pos2 = new Pos(X, Y+w); pos2.TilePos();
		pos3 = new Pos(X+w, Y+w); pos3.TilePos();
		pos4 = new Pos(X+w, Y); pos4.TilePos();
		pos5 = new Pos(X+13, Y+7); pos5.TilePos();
		pos6 = new Pos(X, Y+8); pos6.TilePos();
		pos7 = new Pos(X+7, Y); pos7.TilePos();
		pos8 = new Pos(X+7, Y+13); pos8.TilePos();
		
		//gc.guiRenderer.drawInTile((int)pos1.X, (int)pos1.Y);
		//gc.guiRenderer.drawInTile((int)pos2.X, (int)pos2.Y);
		//gc.guiRenderer.drawInTile((int)pos3.X, (int)pos3.Y);
		//gc.guiRenderer.drawInTile((int)pos4.X, (int)pos4.Y);
		//gc.guiRenderer.drawInTile((int)pos5.X, (int)pos5.Y);
		//gc.guiRenderer.drawInTile((int)pos6.X, (int)pos6.Y);
		
		if(gc.world.getTile(pos1) != null && gc.world.getTile(pos1).isCollision()) {X = lastPos.X; Y = lastPos.Y;}
		if(gc.world.getTile(pos2) != null && gc.world.getTile(pos2).isCollision()) {X = lastPos.X; Y = lastPos.Y;}
		if(gc.world.getTile(pos3) != null && gc.world.getTile(pos3).isCollision()) {X = lastPos.X; Y = lastPos.Y;}
		if(gc.world.getTile(pos4) != null && gc.world.getTile(pos4).isCollision()) {X = lastPos.X; Y = lastPos.Y;}
		if(gc.world.getTile(pos5) != null && gc.world.getTile(pos5).isCollision()) {X = lastPos.X; Y = lastPos.Y;}
		if(gc.world.getTile(pos6) != null && gc.world.getTile(pos6).isCollision()) {X = lastPos.X; Y = lastPos.Y;}
		if(gc.world.getTile(pos7) != null && gc.world.getTile(pos7).isCollision()) {X = lastPos.X; Y = lastPos.Y;}
		if(gc.world.getTile(pos8) != null && gc.world.getTile(pos8).isCollision()) {X = lastPos.X; Y = lastPos.Y;}
		//if(gc.world.getTile(pos5) != null && gc.world.getTile(pos5).getId() == 3){speed = 0.5f;};
	}

	public void renderer(SpriteBatch batch){
		TextureLoader.player.setPosition(X, Y);
		TextureLoader.player.setRotation(90*direction);
		TextureLoader.player.draw(batch);
	}
	
	public void move(){
		switch(direction){
		case 0: X += speed; break;
		case 1: Y += speed; break;
		case 2: X -= speed; break;
		case 3: Y -= speed; break;
		}
	}
	
	public void boom(){
		SoundLoader.shoot.play(SoundLoader.Volume);
		switch(direction){
		case 0: gc.world.CreateBullet(X+14, Y+6, 2, 0); break;
		case 1: gc.world.CreateBullet(X+7, Y+14, 0, 2); break;
		case 2: gc.world.CreateBullet(X-2, Y+7, -2, 0); break;
		case 3: gc.world.CreateBullet(X+7, Y, 0, -2); break;
		}
	}

	public float getHealth(){
		return this.health;
	}

	public void setDamage(float dmg){
		if(dmg <= health){
			health -= dmg;
		}
	}

	public Rectangle getBound(){
		return this.bound;
	}

}
