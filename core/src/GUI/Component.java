package GUI;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Component {
    private float X, Y;
    private Rectangle bound;
    private boolean Visible;
    protected Action action;
    public static BitmapFont font = new BitmapFont();

    public Component(float X, float Y, boolean Visible){
        this.X = X;
        this.Y = Y;
        this.Visible = Visible;
    }

    public void update(){}

    public void render(SpriteBatch batch){}

    public boolean hover(float X, float Y){return false;}

    public boolean click(float X, float Y){return false;}

    public boolean keyDown(int key){return false;}

    public boolean keyUp(int key){return false;}

    public float getX() {
        return X;
    }

    public float getY() {
        return Y;
    }

    public Rectangle getBound() {
        return bound;
    }

    public boolean isVisible() {
        return Visible;
    }

    public void setX(float x) {
        X = x;
    }

    public void setY(float y) {
        Y = y;
    }

    public void setBound(Rectangle bound) {
        this.bound = bound;
    }

    public void setVisible(boolean visible) {
        Visible = visible;
    }

    public void setPosition(float X, float Y){
        this.X = X;
        this.Y = Y;
    }

    public void setAction(Action action){
        this.action = action;
    }
}
