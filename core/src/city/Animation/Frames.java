package city.Animation;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Frames {
    public Sprite[] sprites;
    private int frame;

    public Frames(Sprite... sprites){
        if(sprites.length == 0){
            System.out.println("Sprites null.");
        }
        frame = 0;
        this.sprites = sprites;
    }

    public boolean hasNext(){
        if(frame + 1 < sprites.length){
            return true;
        }
        return false;
    }

    public Sprite next(){
        frame++;
        if(frame >= sprites.length){
            frame = 0;
        }
        return sprites[frame];
    }

    public Sprite now(){
        return sprites[frame];
    }

    public int getFrame(){
        return frame;
    }

    public Sprite getSpriteToFrame(int frame){
        if(sprites[frame] != null){
            return sprites[frame];
        }
        return now();
    }

    public void end(){
        frame = 0;
    }
}
