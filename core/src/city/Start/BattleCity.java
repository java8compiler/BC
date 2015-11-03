package city.Start;

import city.Animation.AnimationList;
import city.Json.JSONObject;
import city.Loaders.SoundLoader;
import city.Loaders.TextureLoader;
import city.Screens.CrashScreen;
import city.Screens.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BattleCity extends Game {
	public static SpriteBatch batch;
	public static ShapeRenderer shrender;
	public static MenuScreen menu;
	public static GlyphLayout glyphLayout;
	public static JSONObject jsonObject;

	public static String Errors = "Crash/";
	public static String Levels = "Levels/";
	public static String Assets = "Assets/";
	public static String Sounds = "Sounds/";
	public static String Configs = "Configs/";
	public static String Logs = "Logs/";

	@Override
	public void create (){
		FileInputStream file = null;
		byte[] buffer;
		try{
			File log = new File(Logs);
			if(!log.isDirectory()){
				log.mkdir();
			}
			//System.setOut(new PrintStream(new FileOutputStream(Logs+System.currentTimeMillis()+".log")));
			//Load Configs
			file = new FileInputStream(Configs+"settings.json");
			buffer = new byte[file.available()];
			file.read(buffer);
			jsonObject = new JSONObject(new String(buffer, "UTF-8"));

			//Loading Resources
			new TextureLoader();
			new SoundLoader();
			new AnimationList();
			glyphLayout = new GlyphLayout();

			//Init Renderer
			batch = new SpriteBatch();
			shrender = new ShapeRenderer();

			//Set Screen
			menu = new MenuScreen(this);
			Gdx.input.setInputProcessor(menu);
			this.setScreen(menu);

		}catch (Exception e){
			Crash(e);
		}
	}

	//TODO bug not setCrashScreen
	public void Crash(Exception e){
		try {
			//Create file in folder Crash, and write StackTrace.
			File ff = new File(BattleCity.Errors);
			ff.mkdir();
			FileOutputStream outputStream = new FileOutputStream(BattleCity.Errors+"\\"+System.currentTimeMillis()+".txt");
			String str;
			str = System.getProperty("java.version")+"\n"+
					System.getProperty("os.name")+"\n"+
					System.getProperty("os.arch")+"\n";
			outputStream.write(str.getBytes());
			outputStream.flush();
			super.setScreen(new CrashScreen());
			e.printStackTrace(new PrintStream(outputStream));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void ReloadResources(BattleCity city){
		try{
			FileInputStream ff = new FileInputStream(Configs+"settings.json");
			byte[] buffer = new byte[ff.available()];
			ff.read(buffer);
			jsonObject = new JSONObject(new String(buffer, "UTF-8"));

			//Loading Resources
			new TextureLoader();
			new SoundLoader();
		}catch (Exception e){
			city.Crash(e);
		}
	}


}
