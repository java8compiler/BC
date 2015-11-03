package city.Tiles;

public class Stone extends Tile{

	public Stone(int x, int y) {
		super(x, y, 2, true, false, true);
	}
	
	public boolean isCollision(){
		return this.isCollision;
	}
	
	public boolean isBulletCollision(){
		return this.isBulletCollision;
	}
	
	public boolean isKill(){
		return this.isKill;
	}

}
