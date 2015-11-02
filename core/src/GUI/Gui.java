package GUI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Gui {
    private ArrayList<Component> components;
    private Component selectComponent;

    public Gui( ){
        components = new ArrayList<Component>();
    }

    public void add(Component component){
        components.add(component);
        selectComponent = component;
    }

    public void renderer(SpriteBatch batch){
        for (int i = 0; i < components.size(); i++){
           if(components.get(i).isVisible()){
               components.get(i).render(batch);
           }
        }
    }

    public void click(float X, float Y){
        for (int i = 0; i < components.size(); i++){
            if(components.get(i).isVisible() && components.get(i).click(X, Y)){
                selectComponent = components.get(i);
            }
        }
    }

    public void hover(float X, float Y){
        for (int i = 0; i < components.size(); i++){
            if(components.get(i).isVisible()){
                components.get(i).hover(X, Y);
            }
        }
    }

    public void keyDown(int key){
        if(selectComponent != null){
            selectComponent.keyDown(key);
        }
    }

    public void setSelectComponent(Component component){
        selectComponent = component;
    }
}
