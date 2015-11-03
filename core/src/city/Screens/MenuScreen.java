package city.Screens;

import city.GUI.Action;
import city.GUI.Component;
import city.GUI.Gui;
import city.GUI.TButton;
import city.Start.BattleCity;
import city.Loaders.TextureLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class MenuScreen implements Screen, InputProcessor{
	private OrthographicCamera camera;
	private Gui gui;
	private TButton RESUME, NEW, SAVE, OPTIONS, EXIT;
	private BattleCity city;
	private GameContainer container;
	private LevelSelectScreen selectScreen;
	private OptionsScreen optionsScreen;

	public MenuScreen(BattleCity c) throws Exception{
		this.city = c;
		container = new GameContainer(c);
		selectScreen = new LevelSelectScreen(c, container ,this);
		optionsScreen = new OptionsScreen(c);
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		gui = new Gui();
		camera.zoom = 0.8f;
		RESUME = new city.GUI.TButton(0, 100, "Resume");
		RESUME.setVisible(false);
		NEW = new city.GUI.TButton(0, 80, "New");
		SAVE = new city.GUI.TButton(0, 60, "Save");
		OPTIONS = new city.GUI.TButton(0, 40, "Options");
		EXIT = new city.GUI.TButton(0, 20, "Exit");
		RESUME.setAction(new Action() {
			@Override
			public void action(Component component) {
				city.setScreen(container);
				Gdx.input.setInputProcessor(container);
			}
		});
		NEW.setAction(new Action() {
			@Override
			public void action(Component component) {
				city.setScreen(selectScreen);
				Gdx.input.setInputProcessor(selectScreen);
				ResumeVisible(false);
			}
		});
		SAVE.setAction(new Action() {
			@Override
			public void action(Component component) {
				System.out.println("SAVE");
			}
		});
		OPTIONS.setAction(new Action() {
			@Override
			public void action(Component component) {
				System.out.println("OPTIONS");
			}
		});
		EXIT.setAction(new Action() {
			@Override
			public void action(Component component) {
				System.exit(0);
			}
		});
		gui.add(RESUME);
		gui.add(NEW);
		gui.add(SAVE);
		gui.add(OPTIONS);
		gui.add(EXIT);
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(button == 0){
			Vector3 pos = camera.unproject(new Vector3(screenX, screenY, 0));
			gui.click(pos.x, pos.y);
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		Vector3 pos = camera.unproject(new Vector3(screenX, screenY, 0));
		gui.hover(pos.x, pos.y);
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		BattleCity.WorldBatch.setProjectionMatrix(camera.combined);
		BattleCity.WorldBatch.begin();
		TextureLoader.MainBoard.setPosition(-80, 150);
		TextureLoader.MainBoard.draw(BattleCity.WorldBatch);
		gui.renderer(BattleCity.WorldBatch);
		BattleCity.WorldBatch.end();
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

	public void ResumeVisible(boolean v){
		RESUME.setVisible(v);
	}
}
