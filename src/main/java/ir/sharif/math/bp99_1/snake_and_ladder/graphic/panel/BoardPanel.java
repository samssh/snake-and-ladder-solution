package ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.GraphicalAgent;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners.BoardMouseListener;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.models.GraphicalBoard;
import ir.sharif.math.bp99_1.snake_and_ladder.util.Config;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    protected final GraphicalBoard board;
    protected final GraphicalAgent agent;


    public BoardPanel(GraphicalBoard board, GraphicalAgent agent) {
        this.board = board;
        this.agent = agent;
        config();
        addMouseListener(new BoardMouseListener(agent));
        requestFocus();
    }

    private void config() {
        Config config = Config.getConfig("boardPanel");
        setBounds(config.getProperty(Integer.class, "x"), config.getProperty(Integer.class, "y")
                , config.getProperty(Integer.class, "width"), config.getProperty(Integer.class, "height"));
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics gs) {
        super.paintComponent(gs);
        Graphics2D g = (Graphics2D) gs;
        synchronized (agent.getPaintLock()) {
            board.paint(g);
        }
        /*int k = color;
        int tool = get("width") / get("square");
        int arz = get("height") / get("square");

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


        // this is also for test, i draw a red pawn just to know it works :)
        g.drawImage(ImageLoader.getImage("redPawn"), x, y, square, square, null);
        if (selected) {
            g.setStroke(new BasicStroke(get("selectStroke")));
            g.setColor(Color.MAGENTA);
            g.drawRect(x, y, square, square);
        }

        g.setStroke(s);*/
    }

}
