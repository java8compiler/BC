package city.Entities;

import city.Pos;
import city.World;

public class Entity {
    private Pos pos;
    private byte id;

    protected Entity(float x, float y, byte id){
        pos = new Pos(x, y);
        this.id = id;
    }

    public void update(World world){

    }

    public byte getId(){return this.id;}

    public Pos getPos(){return this.pos;}
}
