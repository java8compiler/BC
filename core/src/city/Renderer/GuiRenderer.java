package city.Renderer;

import city.Loaders.TextureLoader;
import city.Screens.GameContainer;
import city.Utils.Pos;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
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
	public boolean Shop;
	private HealthRenderer healthRenderer;
	private ShopRenderer shopRenderer;

	private int hX, hY;

	public GuiRenderer(GameContainer gc) throws Exception {
		this.gc = gc;
		r = new ShapeRenderer();
		font = new BitmapFont();
		healthRenderer = new HealthRenderer();
		shopRenderer = new ShopRenderer(new Pos(100, 100), 5, 5);
		Shop = false;
	}

	public void renderer(SpriteBatch batch) throws Exception {
		hX = 100;
		hY = 100;
		font.draw(batch, "FPS" + Gdx.graphics.getFramesPerSecond(), 0, 0);
		healthRenderer.render(gc);
		//Shop

		if(Shop){
			shopRenderer.render(batch);
		}
	}

	public void Click(int button, int X, int Y){}

	public void Move(int X, int Y){}

	public  void Drag(int X, int Y){}
	
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
