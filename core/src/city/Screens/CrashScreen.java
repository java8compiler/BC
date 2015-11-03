package city.Screens;

import city.Start.BattleCity;
import city.Loaders.TextureLoader;
import com.badlogic.gdx.Screen;

public class CrashScreen implements Screen {
    public CrashScreen(){
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(!BattleCity.batch.isDrawing()) BattleCity.batch.begin();
        BattleCity.batch.draw(TextureLoader.crash, -200, -200, 400, 400);
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
