package city.Renderer;

import city.Loaders.TextureLoader;
import city.Screens.GameContainer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;

public class GuiRenderer {
	private GameContainer gc;
	private ShapeRenderer r;
	private BitmapFont font;

	private int hX, hY;

	public GuiRenderer(GameContainer gc) throws Exception {
		this.gc = gc;
		r = new ShapeRenderer();
		font = new BitmapFont();
	}

	public void renderer(SpriteBatch batch) throws Exception {
		hX = 100;
		hY = 100;
		float zoom = gc.camera.zoom;
		gc.camera.zoom = 1;
		gc.camera.update();
		batch.setProjectionMatrix(gc.camera.combined);
		Vector3 fpsPos = gc.camera.unproject(new Vector3(0, 0, 0));
		font.draw(batch, "FPS" + Gdx.graphics.getFramesPerSecond(), fpsPos.x, fpsPos.y);

		float health = gc.world.getPlayer().getHealth();
		for (int i = 0; i <= gc.world.getPlayer().getHealth(); i++) {
			Vector3 pos = gc.camera.unproject(new Vector3(hX, hY, 0));
			if(health >= 1){
				TextureLoader.health.setScale(3, 3);
				TextureLoader.health.setPosition(pos.x, pos.y);
				TextureLoader.health.draw(batch);
				hX += 50;
			}else{
				if(health < 1 && health > 0){
					TextureLoader.halfHealth.setScale(3, 3);
					TextureLoader.halfHealth.setPosition(pos.x, pos.y);
					TextureLoader.halfHealth.draw(batch);
				}

			}
			health--;
		}

		gc.camera.zoom = zoom;
		gc.camera.update();
	}
	
	public void drawInTile(int x, int y) throws Exception{
		r.setProjectionMatrix(gc.camera.combined);
		r.begin(ShapeType.Line);
		r.box(x*8, y*8, 0, 8, 8, 0);
		r.end();
	}
	
	public void drawPoint(int x, int y) throws Exception{
		r.setProjectionMatrix(gc.camera.combined);
		r.setColor(Color.RED);
		r.begin(ShapeType.Line);
		r.circle(x, y, 1);
		r.end();
	}
}
