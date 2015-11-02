package city.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import city.BattleCity;
import city.Settings;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Settings.WIDTH;
		config.height = Settings.HEIGHT;
		new LwjglApplication(new BattleCity(), config);
	}
}
