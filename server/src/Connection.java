import java.util.ArrayList;

public class Connection extends Thread{
    private boolean status;
    ArrayList<Player> players;

    public Connection(){
        status = true;
        players = new ArrayList<Player>();
    }

    public void run(){
        while (status){}
    }
}
