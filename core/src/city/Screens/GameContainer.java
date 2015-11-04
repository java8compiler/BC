package city.Screens;

import city.Renderer.EffectsRenderer;
import city.Renderer.GuiRenderer;
import city.Renderer.WorldRenderer;
import city.Start.BattleCity;
import city.Utils.Settings;
import city.World.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
	public static SpriteBatch Worldbatch = BattleCity.WorldBatch;
	public static SpriteBatch Screenbatch = BattleCity.ScreenBatch;
	public static ShapeRenderer shrender = BattleCity.shrender;
	public static ShapeRenderer ScreenRender = BattleCity.ScreenRenderer;

	public GameContainer(BattleCity city) throws Exception{
		this.city = city;
		world = new World(100, 100, this, false);
		worldRenderer = new WorldRenderer(world);
		guiRenderer = new GuiRenderer(this);
		effectsRenderer = new EffectsRenderer();
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

			camera.update();
			setMatrix();
			worldRender();
			//screenRender();
			update();

		}catch (Exception e){
			city.Crash(e);
		}
	}

	private void setMatrix(){
		shrender.setProjectionMatrix(camera.combined);
		Worldbatch.setProjectionMatrix(camera.combined);
	}

	private void worldRender() throws Exception{
		Worldbatch.begin();
		shrender.begin(ShapeType.Line);
		worldRenderer.renderer(Worldbatch, shrender);
		effectsRenderer.renderer(Worldbatch);
		Worldbatch.end();
		shrender.end();

	}

	private void screenRender() throws Exception{
		Screenbatch.begin();
		Screenbatch.end();
		ScreenRender.begin(ShapeType.Line);
		guiRenderer.renderer(Screenbatch);
		ScreenRender.end();

	}

	private void update() throws Exception{
		world.update();
		effectsRenderer.update(world);
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
			return false;
		}
		if(keycode == Input.Keys.S){
			guiRenderer.Shop = !guiRenderer.Shop;
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
		guiRenderer.Click(button, screenX, screenX);
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
