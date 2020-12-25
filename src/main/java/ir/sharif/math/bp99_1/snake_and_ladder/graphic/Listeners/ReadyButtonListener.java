package ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.GraphicalAgent;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.models.GraphicalPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadyButtonListener implements ActionListener {
    private JButton button;
    private GraphicalAgent graphicalAgent;
    private GraphicalPlayer gp;
    private int player;
    private final Color GREEN = Color.GREEN;
    private final Color WHITE = Color.WHITE;
    private boolean clicked;

    public ReadyButtonListener(JButton button, GraphicalAgent graphicalAgent, GraphicalPlayer gp, int player) {
        this.button = button;
        this.graphicalAgent = graphicalAgent;
        this.gp = gp;
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gp.isReady()) {
            button.setBackground(GREEN);
        }else {
            button.setBackground(WHITE);
        }
        graphicalAgent.requestStart(player);

    }
}
