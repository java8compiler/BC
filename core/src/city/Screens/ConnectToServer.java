package city.Screens;

import city.GUI.*;
import city.Start.BattleCity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import java.net.Socket;

public class ConnectToServer implements Screen,InputProcessor {
    private BattleCity city;
    private MenuScreen menuScreen;
    private NetScreen netScreen;
    private Gui gui;

    public ConnectToServer(BattleCity city, MenuScreen menuScreen){
        this.city = city;
        this.menuScreen = menuScreen;
        gui = new Gui();
        TextField ip = new TextField("", 100, 100);
        TButton connect = new TButton("Connect", 100, 200);
        connect.setAction(new Action() {
            @Override
            public void action(Component component) {
               try{
                   Socket socket = new Socket(ip.getText(), 7777);
                   if(socket.isConnected()){
                       netScreen = new NetScreen(city, socket);
                       city.setScreen(netScreen);
                       Gdx.input.setInputProcessor(netScreen);
                   }
               }catch (Exception e){
                   System.out.println("Connection failed.");
               }
            }
        });
        gui.add(connect);
        gui.add(ip);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == 131){
            city.setScreen(menuScreen);
            Gdx.input.setInputProcessor(menuScreen);
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
        screenY = Gdx.graphics.getHeight()-screenY;
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
        screenY = Gdx.graphics.getHeight()-screenY;
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
        BattleCity.ScreenBatch.begin();
        gui.renderer(BattleCity.ScreenBatch);
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
