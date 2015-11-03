package city.Renderer;

import city.GUI.Slot;
import city.Loaders.TextureLoader;
import city.Utils.Pos;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShopRenderer {
    private int W,H;
    private Pos pos;
    private Slot[][] slots;

    public ShopRenderer(Pos pos, int W, int H){
        this.pos = pos;
        this.W = W;
        this.H = H;
    }

    public void render(SpriteBatch batch){
    }

    public void Click(int button,int X, int Y){
    }
}
