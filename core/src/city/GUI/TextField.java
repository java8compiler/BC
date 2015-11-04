package city.GUI;

import city.Start.BattleCity;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class TextField extends Component{
    private String text;
    private int pos;

    public TextField(String text, float X, float Y) {
        super(X, Y, true);
        this.text = text;
        pos = 0;
        BattleCity.glyphLayout.setText(font, text);
        Rectangle bound = new Rectangle(X, Y, BattleCity.glyphLayout.width, BattleCity.glyphLayout.height);
        setBound(bound);
    }

    public void setText(String text){
        this.text = text;
        BattleCity.glyphLayout.setText(font, text);
        Rectangle bound = new Rectangle(getX(), getY(), BattleCity.glyphLayout.width, BattleCity.glyphLayout.height);
        setBound(bound);
    }

    public void setPosition(float X, float Y){
        getBound().setPosition(X, Y);
    }

    @Override
    public boolean keyDown(int key) {
        if(Input.Keys.LEFT == key){
            if(pos > 0) pos--;
        }else
        if (Input.Keys.RIGHT == key){
            if(pos < text.length()) pos++;
        }else{
            setText(this.text+String.valueOf(key));
        }
        return false;
    }

    @Override
    public void render(SpriteBatch batch) {
        font.draw(batch, this.text, getX(), getY());
    }
}
