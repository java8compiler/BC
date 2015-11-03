package city.GUI;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Slot extends Component {
    private Sprite background;
    private Sprite sprite;

    public Slot(Sprite background, Sprite sprite, float X, float Y) {
        super(X, Y, true);
        this.background = background;
        this.sprite = sprite;
        setBound(new Rectangle(X, Y, background.getWidth(), background.getHeight()));
    }

    @Override
    public void render(SpriteBatch batch) {
        background.setPosition(getX(), getY());
        background.draw(batch);
        sprite.setPosition(getX()+5, getY()+5);
        sprite.draw(batch);
    }
}