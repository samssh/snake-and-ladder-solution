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

        p1.setBounds(get("infoX1"), get("infoY"), get("infoWidth"), get("infoHeight"));
        p2.setBounds(get("infoX2"), get("infoY"), get("infoWidth"), get("infoHeight"));

        board = new BoardPanel();
        board.setBounds(get("boardX"),get("boardY"),get("boardWidth"), get("boardHeight"));
        add(board);

        add(p1);
        add(p2);
    }

    public MainPanel(String player1, String player2, int score1, int score2) {
        config();
        p1 = new PlayerInfoPanel(this , player1, 1024, 1, 0);
        p2 = new PlayerInfoPanel(this , player2, 1024, 2, 1);

        p1.setBounds(get("infoX1"), get("infoY"), get("infoWidth"), get("infoHeight"));
        p2.setBounds(get("infoX2"), get("infoY"), get("infoWidth"), get("infoHeight"));

        board = new BoardPanel();
        board.setBounds(get("boardX"),get("boardY"),get("boardWidth"), get("boardHeight"));

        add(board);
        add(p1);
        add(p2);

        setFocusable(true);
        requestFocus();
    }

    private void config() {
        config = Config.getConfig("mainPanel");
        setSize(new Dimension(get("width"), get("height")));
        setLayout(null);
    }

    private int get(String property){
        return config.getProperty(Integer.class , property);
    }

    public void changeTurn(PlayerInfoPanel p, int r){
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
