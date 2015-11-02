package city;

public class Pos {
	public float X, Y;
	
	public Pos(float x, float y){
		X = x;
		Y = y;
	}
	
	public void TilePos(){
		X = X/8;
		Y = Y/8;
	}
}
