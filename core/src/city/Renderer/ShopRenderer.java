package city.Renderer;

import city.GUI.Slot;
import city.Loaders.TextureLoader;
import city.Start.BattleCity;
import city.Utils.Pos;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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
        BattleCity.ScreenRenderer.arc(500, 500, 10, 10, 10, 10);
    }

    public void Click(int button,int X, int Y){
    }
}
