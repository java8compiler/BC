package city.Net;

import city.GUI.Gui;
import city.GUI.TextField;
import city.Start.BattleCity;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

public class ConnectToServer implements Screen,InputProcessor {
    private BattleCity city;
    private Gui gui;

    public ConnectToServer(BattleCity city){
        this.city = city;
        gui = new Gui();
        TextField ip = new TextField("", 100, 100);
        gui.add(ip);
    }

    @Override
    public boolean keyDown(int keycode) {
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
        gui.click(screenX, screenY);
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
        gui.hover(screenX, screenY);
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
        BattleCity.ScreenRenderer.begin();
        gui.renderer(BattleCity.ScreenBatch);
        BattleCity.ScreenRenderer.end();
    }

    @Override
    public void resize(int width, int height) {

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
}
