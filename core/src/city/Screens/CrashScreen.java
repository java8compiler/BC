package city.Screens;

import city.BattleCity;
import city.Loaders.TextureLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CrashScreen implements Screen {
    public CrashScreen(){
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        BattleCity.batch.begin();
        BattleCity.batch.draw(TextureLoader.crash, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        BattleCity.batch.end();
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
