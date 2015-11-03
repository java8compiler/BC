package city.Animation;

public class Animation {
    private long period;
    private long lastTime;
    private int maxStage;
    protected int stage = 0;
    public boolean Live = true;


    public Animation(long period, int maxStage){
        this.period = period;
        this.maxStage = maxStage-1;
        lastTime = System.currentTimeMillis();
    }

    protected void update(){
        if(System.currentTimeMillis()-lastTime >= period){
            lastTime = System.currentTimeMillis();
            if(stage >= maxStage){
                Live = false;
            }else {
                stage++;
                Stage();
            }
        }
    }

    protected void Stage(){}
}
