package city.GUI;

import city.Start.BattleCity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class TButton extends Component {
	private String text;
	private boolean Hover;

	public TButton(float X, float Y, String text) {
		super(X, Y, true);
		this.text = text;
		BattleCity.glyphLayout.setText(font, text);
		Rectangle bound = new Rectangle(X, Y-BattleCity.glyphLayout.height, BattleCity.glyphLayout.width, BattleCity.glyphLayout.height);
		//System.out.println(bound.getX()+" "+bound.getY()+" "+bound.getWidth()+" "+bound.getHeight());
		this.setBound(bound);
	}

	public void render(SpriteBatch batch){
		if(Hover){
			font.setColor(Color.RED);
			font.draw(batch, text, this.getX(), this.getY());
		}else{
			font.draw(batch, text, this.getX(), this.getY());

		}
		font.setColor(Color.WHITE);
	}

	public boolean hover(float X, float Y){
		Hover = false;
		if(getBound().contains(X, Y)){
			Hover = true;
			return true;
		}
		return false;
	}

	public boolean click(float X, float Y){
		if(getBound().contains(X, Y)){
			action.action(this);
			return true;
		}
		return false;
	}

	public boolean keyDown(int key){
		return super.keyDown(key);
	}

	public String getText(){
		return this.text;
	}
}
