package ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Config;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private int x, y, width, height;
    private int a,b;
    private Config config;
    int color = 0;
    int square;

    public BoardPanel() {
        config = Config.getConfig("boardPanel");
        config();
    }


    private void config(){

        setSize(new Dimension(config.getProperty(Integer.class, "width")
                , config.getProperty(Integer.class, "height")));
        setLayout(null);
        square = config.getProperty(Integer.class , "square");

    }

    @Override
    protected void paintComponent(Graphics g) {
        int k = color;
        int tool = config.getProperty(Integer.class , "width") / config.getProperty(Integer.class , "square");
        int arz = config.getProperty(Integer.class , "height") / config.getProperty(Integer.class , "square");
        for (int i = 0; i < tool; i++) {
            for (int j = 0; j < arz; j++) {
                if (k%5 ==0) g.setColor(Color.white);
                else if (k%5 == 1) g.setColor(Color.yellow);
                else if (k%5 == 2) g.setColor(Color.green);
                else if(k%5 == 3) g.setColor(Color.PINK);
                else g.setColor(Color.blue);
                g.fillRect(i*square,j*square,square,square);
                k++;
            }
        }
        g.setColor(Color.BLACK);
        for (int i = 0; i < tool; i++) {
            for (int j = 0; j < arz; j++) {
                g.drawRect(i*square,j*square,square,square);
                k++;
            }
        }

        Graphics2D gs = (Graphics2D)g;
        Stroke s = gs.getStroke();
        gs.setStroke(new BasicStroke(10));
        gs.drawLine(0,560,1280,560);
        gs.setStroke(s);
    }
}
