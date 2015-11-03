package city.Loaders;

import city.Start.BattleCity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;

import java.io.File;

public class SoundLoader {
	public static Sound shoot;
	public static Sound explosion;
	public static float Volume;

	public SoundLoader() throws Exception{
		shoot = Load("Shoot.wav");
		explosion = Load("Explosion.wav");

		Volume = (float)BattleCity.jsonObject.getJSONObject("Sound").getDouble("Volume");
	}

	public static Sound Load(String filename) throws Exception{
		return Gdx.audio.newSound(new FileHandle(new File(BattleCity.Sounds+filename)));
	}
}
