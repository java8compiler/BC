package city.GUI;

import java.util.ArrayList;

public class TList extends Component {
    private ArrayList<Component> list;

    public TList(float X, float Y) {
        super(X, Y, true);
        list = new ArrayList<Component>();
    }

    public void render(){}

    public void addComponent(Component component){
        list.add(component);
    }
}
