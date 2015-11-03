package city.Renderer;

import city.Loaders.TextureLoader;
import city.Screens.GameContainer;
import city.Start.BattleCity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HealthRenderer {
    public HealthRenderer(){}

    public void render(GameContainer container){
        int hX = 100, hY = 100;
        float health = container.world.getPlayer().getHealth();
        for (int i = 0; i <= container.world.getPlayer().maxHealth; i++){
            if(health >= 1){
                TextureLoader.health.setScale(3, 3);
                TextureLoader.health.setPosition(hX, hY);
                TextureLoader.health.draw(BattleCity.ScreenBatch);
                hX += TextureLoader.health.getBoundingRectangle().width+10;
            }else{
                if(health < 1 && health > 0){
                    TextureLoader.halfHealth.setScale(3, 3);
                    TextureLoader.halfHealth.setPosition(hX, hY);
                    TextureLoader.halfHealth.draw(BattleCity.ScreenBatch);
                }

            }
            health--;
        }
    }
}
