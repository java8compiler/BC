package city.Screens;

import city.Start.BattleCity;
import city.Loaders.TextureLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class CrashScreen implements Screen {
    public CrashScreen(){
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(!BattleCity.ScreenBatch.isDrawing()) BattleCity.ScreenBatch.begin();
        BattleCity.ScreenBatch.draw(TextureLoader.crash, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        BattleCity.ScreenBatch.end();
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
