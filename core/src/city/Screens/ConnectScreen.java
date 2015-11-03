package city.Screens;


import city.Start.BattleCity;
import com.badlogic.gdx.Gdx;

import javax.swing.*;

public class ConnectScreen extends JFrame{
    private JTextField ip;
    private JButton enter;
    private JLabel ip_text;
    private BattleCity c;

    public ConnectScreen(BattleCity city){
        super("Connect");
        c = city;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 500, 300);
        super.setLayout(null);
        ip = new JTextField("");
        enter = new JButton("Connect");
        ip_text = new JLabel("Ip:");
        ip.setBounds(200, 100, 125, 25);
        enter.setBounds(200, 200, 100, 25);
        ip_text.setBounds(160,100, 50, 25);
        this.add(ip);
        this.add(enter);
        this.add(ip_text);
        this.setVisible(true);
    }

}
