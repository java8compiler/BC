import java.net.Socket;

public class Player {
    public int X,Y;
    public Socket socket;
    public Player(Socket s,int x, int y){
        socket = s;
        X = x;
        Y = y;
    }
}
