package city;

import java.util.ArrayList;

import Tiles.Tile;

import city.Json.Entity.Entity;
import city.Loaders.TextureLoader;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class WorldRenderer {
	private World world;
	private byte Water_texture;
	private int watercount;
	
	public WorldRenderer(World world){
		this.world = world;
		Water_texture = 1;
		watercount = 0;
	}
	
	public void renderer(final SpriteBatch batch, final ShapeRenderer shrender) throws Exception{
		watercount++;
		if(watercount > 30){
			if(Water_texture == 1) Water_texture = 2; else Water_texture = 1;
			watercount = 0;
		}
		Tile[][] tiles = world.geTiles();
		int sx = world.getSizeX();
		int sy = world.getSizeY();
		for(int x = 0;x < sx; x++){
			for(int y = 0;y < sy; y++){
				if(tiles[x][y] != null){
					switch(tiles[x][y].getId()){
					case 0: TextureLoader.null_tile.setPosition(x*8, y*8);break;
					case 1: TextureLoader.brick.setPosition(x*8, y*8); TextureLoader.brick.draw(batch); break;
					case 2: TextureLoader.stone.setPosition(x*8, y*8); TextureLoader.stone.draw(batch); break;
					case 3: TextureLoader.leaf.setPosition(x*8, y*8); TextureLoader.leaf.draw(batch); break;
					case 4: if(Water_texture == 1){TextureLoader.water_1.setPosition(x*8, y*8);TextureLoader.water_1.draw(batch);} else {TextureLoader.water_2.setPosition(x*8, y*8);TextureLoader.water_2.draw(batch);}
					default:break;
					}
				}else{
					TextureLoader.null_tile.setPosition(x*8, y*8); TextureLoader.null_tile.draw(batch);
				}
			}
		}

		ArrayList<Entity> entities = world.getEntities();
		Entity entity = null;
		for(int i = 0;i < entities.size();i++){
			entity = entities.get(i);
			switch(entity.getId()){
				case 0:
			}
		}

		world.getPlayer().renderer(batch);
		ArrayList<Bullet> bullets = world.getBulletList();
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).draw(shrender);
		}
	}
}
