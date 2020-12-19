package ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Config;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.ImageLoader;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners.MyMouseListener;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoPanel extends JPanel {
    private MainPanel p ;
    private JLabel name;
    private JLabel score;
    JLabel dice;
    private JLabel diceNumber;
    private JButton whosTurn;
    private Config config;
    private Icon img;

    {
        img = new ImageIcon("src/main/resources/ir/sharif/math/bp99_1/snake_and_ladder/images/dice.gif");
    }

    public PlayerInfoPanel(MainPanel p ,String player, int sc, int color, int turn) {
        this.p = p;
        config();
        Initilize(player, sc, color,turn);
    }

    private void config() {
        config = Config.getConfig("infopanel");
        setSize(new Dimension(config.getProperty(Integer.class, "width")
                , config.getProperty(Integer.class, "height")));
        setLayout(null);

    }

    private void Initilize(String player, int sc, int color ,int turn) {
        setVisible(true);
        name = new JLabel("Name :  " + player);
        name.setFont(name.getFont().deriveFont(20.0f));
        score = new JLabel("Score :  " + sc);
        score.setFont(score.getFont().deriveFont(20.0f));
        dice = new JLabel(img);
        diceNumber = new JLabel();
        whosTurn = new JButton();

        coloring(color, turn);
        Positioning();
        addElements();
    }

    private void coloring(int color , int turn){
        if (color == 1) {
            setBackground(Color.CYAN);
        } else {
            setBackground(Color.yellow);
        }
        if(turn%2 == 0){
            whosTurn.setBackground(Color.green);
        }else {
            whosTurn.setBackground(Color.red);
        }
        whosTurn.setEnabled(false);
    }

    private void Positioning() {
        name.setBounds(get("nameX"), get("nameY"), get("width1"), get("length1"));
        score.setBounds(get("scoreX"), get("scoreY"), get("width1"), get("length1"));
        whosTurn.setBounds(get("turnX"), get("y"), get("square"), get("square"));
        diceNumber.setBounds(get("diceBX"), get("y"), get("square"), get("square"));
        dice.setBounds(get("diceX"), get("y"), get("square"), get("square"));
        dice.addMouseListener(new MyMouseListener(p,this));
    }

    private void addElements() {
        add(name);
        add(score);
        add(whosTurn);
        add(diceNumber);
        add(dice);
    }

    private int get(String name) {
        return config.getProperty(Integer.class, name);
    }

    void turn(int i , int r){
        if (i == 1) whosTurn.setBackground(Color.green);
        else{
            whosTurn.setBackground(Color.red);
            Image image;
            Icon s = ImageLoader.getIcon(r);
            System.out.println(s);
            diceNumber.setIcon(s);
        }
        revalidate();
    }
}
