package city.Net;

import city.Start.BattleCity;
import com.badlogic.gdx.Screen;

public class MultiPlayerScreen implements Screen{
    private Connection connection;

    public MultiPlayerScreen(Connection connection){
        this.connection = connection;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        BattleCity.WorldBatch.begin();

        BattleCity.WorldBatch.end();
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
