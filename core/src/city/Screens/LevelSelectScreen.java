package city.Screens;

import city.GUI.Action;
import city.GUI.Component;
import city.GUI.Gui;
import city.GUI.TButton;
import city.Start.BattleCity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

import java.io.File;
import java.io.FileInputStream;

public class LevelSelectScreen implements Screen, InputProcessor {

    private OrthographicCamera camera;
    private BattleCity city;
    private GameContainer container;
    private MenuScreen menuScreen;
    private Gui gui;
    private  float sY = 100;
    private float Y = 100;
    private float step = 20;
    private Action action = new Action() {
        @Override
        public void action(Component component) {
            TButton button = (TButton)component;
            container.world.loadWorld(BattleCity.Levels+button.getText());
            city.setScreen(container);
            Gdx.input.setInputProcessor(container);
            menuScreen.ResumeVisible(true);
        }
    };

    public LevelSelectScreen(BattleCity city, GameContainer container, MenuScreen menuScreen) throws Exception{
        this.city = city;
        this.container = container;
        this.menuScreen = menuScreen;
        camera = new OrthographicCamera();
        gui = new Gui();
        camera.zoom = 0.5f;
        camera.update();
        load();
    }

    public void load() throws Exception{
        File file = new File(BattleCity.Levels);
        int count = 0;
        for (int i = 0; i < file.list().length; i++){
            if(file.list()[i].matches("\\w+\\.level") && (new FileInputStream(BattleCity.Levels+file.list()[i]).available()) == 10000){
                BattleCity.glyphLayout.setText(TButton.font, file.list()[i]);
                TButton button = new TButton(file.list()[i], -3-BattleCity.glyphLayout.width/2, Y);
                button.setAction(action);
                gui.add(button);
                Y += button.getBound().getHeight()+10;
                step = button.getBound().getHeight();
                count++;
            }
        }
        System.out.println("Levels="+count);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(Gdx.input.isKeyPressed(19)){
            if(camera.position.y < Y){
                camera.position.y += step;
                camera.update();
            }
        }
        if(Gdx.input.isKeyPressed(20)){
            if(camera.position.y > sY){
                camera.position.y -= step;
                camera.update();
            }
        }
        BattleCity.WorldBatch.setProjectionMatrix(camera.combined);
        BattleCity.WorldBatch.begin();
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

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == 131){
            city.setScreen(BattleCity.menu);
            Gdx.input.setInputProcessor(BattleCity.menu);
        }
        gui.keyDown(keycode);
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
        Vector3 pos = camera.unproject(new Vector3(screenX, screenY, 0));
        gui.click(pos.x, pos.y);
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
}
