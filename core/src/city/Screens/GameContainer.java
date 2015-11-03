package city.Screens;

import city.Renderer.EffectsRenderer;
import city.Renderer.GuiRenderer;
import city.Renderer.WorldRenderer;
import city.Start.BattleCity;
import city.Utils.Settings;
import city.World.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameContainer implements Screen,InputProcessor{
	public OrthographicCamera camera;
	public World world;
	public WorldRenderer worldRenderer;
	public GuiRenderer guiRenderer;
	public EffectsRenderer effectsRenderer;
	public BattleCity city;
	public static SpriteBatch batch = BattleCity.batch;
	public static ShapeRenderer shrender = BattleCity.shrender;

	public GameContainer(BattleCity city) throws Exception{
		this.city = city;
		world = new World(100, 100, this);
		worldRenderer = new WorldRenderer(world);
		guiRenderer = new GuiRenderer(this);
		effectsRenderer = new EffectsRenderer(this);
		camera = new OrthographicCamera(Settings.WIDTH, Settings.HEIGHT);
		camera.zoom = 0.3f;
		camera.position.set(0, 0, 0);
	}

	@Override
	public void show() {}

	@Override
	public void render(float delta) {
		try{
			//Clear Screen
			Gdx.gl.glClearColor(0, 0, 0, 0);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			//Camera update
			camera.update();

			//Set Matrix
			shrender.setProjectionMatrix(camera.combined);
			batch.setProjectionMatrix(camera.combined);

			//Renderer begin
			shrender.begin(ShapeType.Line);
			batch.begin();

			//Render world, effects, gui
			worldRenderer.renderer(batch, shrender);
			effectsRenderer.renderer(batch);
			guiRenderer.renderer(batch);

			//Renderer end
			batch.end();
			shrender.end();
			effectsRenderer.update();

			//World update
			world.update();
		}catch (Exception e){
			city.Crash(e);
		}
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.update();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == 131){
			city.setScreen(BattleCity.menu);
			Gdx.input.setInputProcessor(BattleCity.menu);
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		if(amount < 0 && camera.zoom > 0.3){
			camera.zoom -=0.1f;
		}
		if(amount > 0 && camera.zoom < 1.5f){
			camera.zoom +=0.1f;
		}
		return false;
	}

}
