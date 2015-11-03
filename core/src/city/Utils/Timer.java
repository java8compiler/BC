package city.Utils;

import city.Screens.GameContainer;

public class Timer {
    private long time;
    private long lastTime;
    private Operation operation;
    public boolean Live;
    private GameContainer container;

    public Timer(GameContainer container, long miliseconds, Operation operation){
        time = miliseconds;
        lastTime = System.currentTimeMillis();
        this.operation = operation;
        this.container = container;
        Live = true;
    }

    public void update(long nowTime) throws Exception{
        if(nowTime-lastTime >= time){
            operation.operation(container);
            Live = false;
        }
    }
}
