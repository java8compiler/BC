package city.GUI;

import city.Start.BattleCity;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import java.awt.event.KeyEvent;

public class TextField extends Component{
    private String text;
    private int pos;

    public TextField(String text, float X, float Y) {
        super(X, Y, true);
        this.text = text;
        pos = 0;
        BattleCity.glyphLayout.setText(font, text);
        setText(text);
        getBound().setWidth(50);
    }

    public void setText(String text){
        this.text = text;
        BattleCity.glyphLayout.setText(font, text);
        Rectangle bound = new Rectangle(getX()+10, getY()+30, BattleCity.glyphLayout.width+5, BattleCity.glyphLayout.height+5);
        setBound(bound);
    }

    public String getText(){
        return this.text;
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
        }if(Input.Keys.DEL == key){
            if(this.text.length() > 0){
                String str = this.text.substring(0, this.text.length()-1);
                setText(str);
            }
        }else{
            setText(this.text + Input.Keys.toString(key));
        }
        return false;
    }

    @Override
    public boolean click(float X, float Y) {
        //System.out.println(getBound().getX()+" "+getBound().getY()+" "+getBound().getWidth()+" "+getBound().getHeight());
        if(getBound().contains(X, Y)){
            return true;
        }
        return false;
    }

    @Override
    public void render(SpriteBatch batch) {
        font.draw(batch, this.text, getX(), getY());
        batch.end();
        if(!BattleCity.ScreenRenderer.isDrawing()){BattleCity.ScreenRenderer.begin(ShapeRenderer.ShapeType.Line);}
        BattleCity.ScreenRenderer.box(getX(), getY(), 0, getBound().getWidth(),-getBound().getHeight(), 0);
        BattleCity.ScreenRenderer.end();
        batch.begin();
    }
}
