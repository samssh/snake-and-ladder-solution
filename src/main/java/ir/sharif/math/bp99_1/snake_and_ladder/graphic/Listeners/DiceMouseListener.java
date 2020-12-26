package ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.GraphicalAgent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DiceMouseListener implements MouseListener {

    private final GraphicalAgent graphicalAgent;
    private final int player;

    public DiceMouseListener(GraphicalAgent graphicalAgent, int player) {
        this.graphicalAgent = graphicalAgent;
        this.player = player;
    }

    /**
     * TO DO ...
     * <p>
     * when user click the dice label ,
     * send a request to the logic to roll the dice for him
     */


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        graphicalAgent.diceRequest(player);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
