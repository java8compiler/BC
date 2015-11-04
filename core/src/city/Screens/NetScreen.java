package city.Screens;

import city.Net.Connection;
import city.Net.NetworkWorld;
import city.Net.Packet.Packet;
import city.Net.Packet.PacketLoadLevel;
import city.Net.Packet.PacketSetPlayerCoords;
import city.Net.Packet.PacketYouId;
import city.Renderer.EffectsRenderer;
import city.Renderer.WorldRenderer;
import city.Start.BattleCity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.net.Socket;

public class NetScreen implements Screen, InputProcessor{
    public BattleCity city;
    public Connection connection;
    public NetworkWorld world;
    public WorldRenderer worldRenderer;
    public EffectsRenderer effectsRenderer;
    public OrthographicCamera camera;
    public byte MyId;

    public NetScreen(BattleCity city, Socket socket) throws Exception{
        this.city = city;
        connection = new Connection(socket);
        connection.start();
        world = new NetworkWorld(100, 100, connection, this);
        worldRenderer = new WorldRenderer(world);
        effectsRenderer = new EffectsRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.zoom = 0.3f;
        camera.update();
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
       try{
           Gdx.gl.glClearColor(0, 0, 0, 0);
           Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
           BattleCity.WorldBatch.setProjectionMatrix(camera.combined);
           BattleCity.shrender.setProjectionMatrix(camera.combined);
           BattleCity.shrender.begin(ShapeRenderer.ShapeType.Line);
           BattleCity.WorldBatch.begin();
           worldRenderer.renderer(BattleCity.WorldBatch, BattleCity.shrender);
           effectsRenderer.renderer(BattleCity.WorldBatch);
           BattleCity.WorldBatch.end();
           BattleCity.shrender.end();

           world.update();

           Packet packet = connection.pull();
           if(packet != null){
               if(packet instanceof Packet){
                   System.out.println(packet.id);
               }
               if(packet instanceof PacketLoadLevel){
                   System.out.println(packet.id);
               }
               if(packet instanceof PacketSetPlayerCoords){
                   System.out.println(packet.id);
               }
               if (packet instanceof PacketYouId){
                   PacketYouId packetYouId = (PacketYouId)packet;
                   MyId = packetYouId.id;
                   System.out.println("My id="+MyId);
               }
           }

       }catch (Exception e){
           city.Crash(e);
       }
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
}
