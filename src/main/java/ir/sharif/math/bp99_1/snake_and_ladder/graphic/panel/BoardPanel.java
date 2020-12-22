package ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Config;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.ImageLoader;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners.BoardMouseListener;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    public int x, y;
    int color;
    int square;
    boolean selected = false;
    private Config config;
    /*    private GameState gs ; */
    /**
     * I think gamestate is neccesary, just to know what to draw
     */


    private int[][] array = new int[7][16];

    /**
     * it is for test , it should be relaced with
     * board in gamestate
     */


    public BoardPanel() {
        config();
        addMouseListener(new BoardMouseListener());

        requestFocus();
    }

    private void config() {
        config = Config.getConfig("boardPanel");
        setSize(new Dimension(config.getProperty(Integer.class, "width")
                , config.getProperty(Integer.class, "height")));
        setLayout(null);
        square = config.getProperty(Integer.class, "square");
        x = 0;
        y = 0;
        color = 0;

    }

    @Override
    protected void paintComponent(Graphics gs) {     /** this paint should change acording to the gamestate */
        Graphics2D g = (Graphics2D)gs ;
        int k = color;
        int tool = get("width") / get("square");
        int arz = get("height") / get( "square");

        // draw colorful tiles
        for (int i = 0; i < tool; i++) {
            for (int j = 0; j < arz; j++) {
                if (k % 5 == 0) g.setColor(Color.white);
                else if (k % 5 == 1) g.setColor(Color.yellow);
                else if (k % 5 == 2) g.setColor(Color.green);
                else if (k % 5 == 3) g.setColor(Color.PINK);
                else g.setColor(Color.blue);
                g.fillRect(i * square, j * square, square, square);
                k++;
            }
        }


        // draw tile borders
        g.setColor(Color.BLACK);
        for (int i = 0; i < tool; i++) {
            for (int j = 0; j < arz; j++) {
                g.drawRect(i * square, j * square, square, square);
                k++;
            }
        }

        // draw  black line down of the board
        Stroke s = g.getStroke();
        g.setStroke(new BasicStroke(get("lineStroke")));
        g.drawLine(0, 560, 1280, 560);


        /** this is also for test, i draw a red pawn just to know it works :) */
        g.drawImage(ImageLoader.getImage("redPawn"), x, y, square, square, null);
        if (selected) {
            g.setStroke(new BasicStroke(get("selectStroke")));
            g.setColor(Color.MAGENTA);
            g.drawRect(x, y, square, square);
        }

        g.setStroke(s);
    }



    private int get(String property){
        return config.getProperty(Integer.class , property);
    }

}
