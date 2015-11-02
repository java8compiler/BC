package city.Net;

import java.net.Socket;

public class Connection extends Thread {
    private boolean status;
    private Socket socket;

    public Connection(Socket socket){
        status = true;
        this.socket = socket;
    }

    public void run(){
        while (status){
        }
    }
}
