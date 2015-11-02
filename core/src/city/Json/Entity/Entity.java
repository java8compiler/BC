package city.Json.Entity;

import city.World;

public class Entity {
    private float X,Y;
    private byte id;

    protected Entity(float x, float y, byte id){
        X = x;
        Y = y;
        this.id = id;
    }

    public void update(World world){

    }

    public byte getId(){return this.id;}

    public float getX(){return X;}
    public float getY(){return Y;}
}
