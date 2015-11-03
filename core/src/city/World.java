package city;
import Tiles.*;
import city.Entities.Entity;
import city.Screens.GameContainer;
import city.Utils.Timer;
import city.Utils.TimerStack;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;

public class World {
	private Tile[][] tiles;
	private int sizeX, sizeY;
	private Player player;
	private GameContainer gc;
	private ArrayList<Bullet> bullets;
	private ArrayList<Entity> entities;
	private Random random;
	private TimerStack timerStack;
	
	public World(int sizeX, int sizeY, GameContainer gc){
		bullets = new ArrayList<Bullet>();
		entities = new ArrayList<Entity>();
		random = new Random();
		timerStack = new TimerStack();
		this.gc = gc;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		tiles = new Tile[sizeX][sizeY];
		player = new Player(40, 40, gc);
	}
	
	public void generate() throws Exception{
		Random r = random;
		Tile tile = null;
		for(int x = 0; x < sizeX; x++){
			for(int y = 0; y < sizeY; y++){
				switch(1){
				case 0: tile = null; break;
				case 1: tile = new Brick(x, y); break;
				case 2: tile = new Stone(x, y); break;
				case 3: tile = new Leaf(x, y); break;
				case 4: tile = new Water(x, y); break;
				default: tile = new Tile(x, y, 0, false, false, false);
				}
				tiles[x][y] = tile;
			}
		}
	}
	
	public void loadWorld(String filename){
		try{
			File f = new File(filename);
			byte[] data = null;
			if(!f.exists()){
				System.out.println(filename+": Level not found.");
				generate();
				return;
			}else{
				try {
					FileInputStream fis = new FileInputStream(f);
					data = new byte[fis.available()];
					fis.read(data);
				} catch (Exception e) {e.printStackTrace();}
			}
			Tile tile = null;
			int i = 0;
			for(int x = 0; x < 100; x++){
				for(int y = 0; y < 100; y++){
					tile = new Tile(x, y, 0, false, false, false);
					if(data[i] == 1) tile = new Brick(x, y); else
					if(data[i] == 2) tile = new Stone(x, y); else
					if(data[i] == 3) tile = new Leaf(x, y); else
					if(data[i] == 4) tile = new Water(x, y);
					tiles[x][y] = tile;
					i++;
				}
			}
		}catch (Exception e){
			gc.city.Crash(e);
		}
	}
	
	public void update() throws Exception{
		player.update();
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).update(this, this.gc.effectsRenderer);
			if(!bullets.get(i).Live) bullets.remove(i);
		}
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).update(this);
		}
		timerStack.update();
	}
	
	public Tile[][] geTiles(){
		return this.tiles;
	}
	public ArrayList<Entity> getEntities(){return this.entities;}
	
	public Tile getTile(int x, int y){
		if(x >= 0 && y >= 0){
			return tiles[x][y];
		}
		return null;
	}
	
	public void setTile(Tile tile){
		int x = tile.getX(), y = tile.getY();
		if (x >= 0 && y >= 0 && x < sizeX && y < sizeY){
			tiles[x][y] = tile;
		} 
	}
	
	public Tile getTile(Pos pos){
		if(pos.X >= 0 && pos.Y >= 0 && pos.X < sizeX && pos.Y < sizeY){
			return tiles[(int)pos.X][(int)pos.Y];
		}
		return null;
	}

	public void DeleteTiles(Pos pos, byte size){
		pos.X -= size/2;
		pos.Y -= size/2;
		for (int x = 0; x < size; x++){
			for (int y = 0; y < size; y++){
				if(getTile(x, y) != null){
					setTile(new Tile((int)pos.X+x, (int)pos.Y+y, 0 , false, false, false));
				}
			}
		}
	}
	
	public ArrayList<Bullet> getBulletList(){ return bullets;}
	
	public void CreateBullet(Pos pos, int dx, int dy){
		bullets.add(new Bullet(pos, dx, dy));
	}
	
	public void CreateBullet(float X, float Y, float dx, float dy){
		bullets.add(new Bullet(new Pos(X, Y), dx, dy));
	}
	
	public void KillBullet(int pos){
		bullets.remove(pos);
	}
	
	public Player getPlayer() {return this.player;}
	
	public int getSizeX() {return this.sizeX;}
	public int getSizeY() {return this.sizeY;}

	public void addTimer(Timer t){
		timerStack.addTimer(t);
	}
}
