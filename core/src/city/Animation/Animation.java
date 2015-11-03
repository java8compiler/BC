package city.Animation;

public class Animation {
    protected long period;
    protected long lastTime;
    protected Frames frames;
    public boolean Live = true;


    public Animation(Frames frames, long period){
        this.period = period;
        lastTime = System.currentTimeMillis();
        this.frames = frames;
    }

    protected void update(){
        if(System.currentTimeMillis()-lastTime >= period){
            lastTime = System.currentTimeMillis();
            if(!frames.hasNext()){
                frames.end();
                Live = false;
            }else {
                frames.next();
                Stage();
            }
        }
    }

    protected void Stage(){}
}
