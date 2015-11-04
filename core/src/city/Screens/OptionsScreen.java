package city.Screens;

import city.GUI.Action;
import city.GUI.Component;
import city.GUI.Gui;
import city.GUI.TButton;
import city.Loaders.SoundLoader;
import city.Start.BattleCity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class OptionsScreen implements Screen, InputProcessor {
    private Gui gui;
    private BattleCity city;

    public OptionsScreen(BattleCity city){
        gui = new Gui();
        this.city = city;
        TButton Volume = new TButton(SoundLoader.Volume+"%", 100, 100);
        Volume.setAction(new Action() {
            @Override
            public void action(Component component) {
                SoundLoader.Volume -= 0.1f;
                if(SoundLoader.Volume <= 0){
                    SoundLoader.Volume = 1;
                }
                ((TButton)component).setText(SoundLoader.Volume*100 + "%");
            }
        });
        gui.add(Volume);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == 131){
            city.setScreen(BattleCity.menu);
            Gdx.input.setInputProcessor(BattleCity.menu);
            return false;
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
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //gui.renderer();
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
