package city.Utils;

import java.util.ArrayList;

public class TimerStack {
    ArrayList<Timer> timers;
    static private final int maxStack = 1000;
    static private final long maxDelta = 10;

    public TimerStack(){
        timers = new ArrayList<Timer>();
    }

    public void addTimer(Timer timer){
        if(timers.size() < maxStack){
            timers.add(timer);
        }else{
            System.out.println("TimerStack>warning<Limit is exceeded.");
        }
    }

    public void update() throws Exception{
        long time = System.currentTimeMillis();
        for (int i = 0; i < timers.size(); i++){
            if(timers.get(i).Live){
                timers.get(i).update(time);
            }else{
                timers.remove(i);
            }
        }
        long delta = System.currentTimeMillis()-time;
        System.out.println(delta);
        if(delta > maxDelta){
            System.out.println("TimeStack>warning<Time out.");
        }
    }
}
