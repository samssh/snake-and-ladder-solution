package ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Config;
import ir.sharif.math.bp99_1.snake_and_ladder.model.GameState;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public PlayerInfoPanel p1;
    public PlayerInfoPanel p2;
    private Config config;
    private BoardPanel board;
    private GameState gs;

    public MainPanel(GameState gs) {
        this.gs = gs;

        config();
        p1 = new PlayerInfoPanel(this , gs.getPlayerOne().getName(), gs.getPlayerOne().getPoint(), 1, 0);
        p2 = new PlayerInfoPanel(this , gs.getPlayerTwo().getName(), gs.getPlayerTwo().getPoint(), 2, 1);

        p1.setBounds(0, 560, 640, 140);
        p2.setBounds(640, 560, 640, 140);

        board = new BoardPanel();
        board.setBounds(0, 0, 1280, 580);
        add(board);

        add(p1);
        add(p2);
    }

    public MainPanel(String player1, String player2, int score1, int score2) {
        config();

        p1 = new PlayerInfoPanel(this , player1, 1024, 1, 0);
        p2 = new PlayerInfoPanel(this , player2, 1024, 2, 1);

        p1.setBounds(0, 560, 640, 140);
        p2.setBounds(640, 560, 640, 140);

        board = new BoardPanel();
        board.setBounds(0, 0, 1280, 580);
        add(board);

        add(p1);
        add(p2);
    }

    private void config() {
        config = Config.getConfig("mainPanel");
        setSize(new Dimension(config.getProperty(Integer.class, "width")
                , config.getProperty(Integer.class, "height")));
        setLayout(null);
    }

    public void changeTurn(PlayerInfoPanel p, int r){
        System.out.println("request");
        if (p.equals(p1)){
            p1.turn(0 , r);
            p2.turn(1 , r);
        }
        if (p.equals(p2)){
            p2.turn(0 , r);
            p1.turn(1 , r);
        }
        revalidate();
        repaint();
    }
}
