package city.Tiles;

public class Tile {
	protected int x,y,id;
	protected boolean isCollision;
	protected boolean isKill;
	protected boolean isBulletCollision;
	
	public Tile(int x, int y, int id, boolean isC, boolean kill, boolean isBC){
		this.x = x;
		this.y = y;
		if(id > 4) id = 0;
		this.id = id;
		isCollision = isC;
		isKill = kill;
		isBulletCollision = isBC;
	}
	
	public int getId(){
		return id;
	}
	
	public boolean isCollision(){
		return isCollision;
	}
	
	public boolean isBulletCollision(){
		return isBulletCollision;
	}
	
	public boolean isKill(){
		return isKill;
	}
	
	public int getX() {return x;}
	public int getY() {return y;}
	
	public int getScreenX() {return x*8;}
	public int getScreenY() {return y*8;}
}
