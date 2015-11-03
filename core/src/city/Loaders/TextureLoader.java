package city.Loaders;

import city.Start.BattleCity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureLoader {
	public static Texture main;
	public static Sprite Slot;
	public static Sprite null_tile;
	public static Sprite brick;
	public static Sprite stone;
	public static Sprite leaf;
	public static Sprite water_1;
	public static Sprite water_2;
	public static Sprite player;
	public static Sprite exp_1_tile;
	public static Sprite exp_2_tile;
	public static Sprite exp_3_tile;
	public static Sprite big_exp_1;
	public static Sprite big_exp_2;

	public static Sprite new_menu;
	public static Sprite save_menu;
	public static Sprite resume_menu;
	public static Sprite exit_menu;

	public static Sprite health;
	public static Sprite halfHealth;

	public static Sprite MainBoard;

	public static Texture crash;

	public TextureLoader() throws Exception{
		main = new Texture(BattleCity.Assets+"sprites.png");
		crash = new Texture(BattleCity.Assets+"crash.png");
		null_tile = Load(0, 104, 8, -8);
		brick = Load(8, 104, 8, -8);
		stone = Load(16, 104, 8, -8);
		leaf = Load(24, 104, 8, -8);
		water_1 = Load(0, 112, 8, -8);
		water_2 = Load(8, 112, 8, -8);
		player = Load(1, 94, 13, -13);
		exp_1_tile = Load(130, 110, 11, -11);
		exp_2_tile = Load(144, 111, 15, -15);
		exp_3_tile  = Load(160, 111, 16, -16);
		big_exp_1 = Load(177, 98, 29, 29);
		big_exp_2 = Load(206, 96, 33, 32);
		new_menu  = Load(0, 254, 15, -7);
		save_menu = Load(16, 254, 19, -7);
		resume_menu = Load(189, 238, 27, 5);
		exit_menu = Load(40, 246, 15, -7);
		MainBoard = Load(0, 0, 188, 68);
		health = new Sprite(new Texture(BattleCity.Assets+"health.png"));
		halfHealth = new Sprite(new Texture(BattleCity.Assets+"half-health.png"));
		Slot = new Sprite(new Texture(BattleCity.Assets+"slot.png"));
	}
	
	public static Sprite Load(int x, int y, int w, int h){
		return new Sprite(new TextureRegion(main, x, y, w, h));
	}
}
