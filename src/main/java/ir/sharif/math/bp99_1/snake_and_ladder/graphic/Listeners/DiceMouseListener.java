package ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.GraphicalAgent;

import java.awt.event.MouseEvent;

public class DiceMouseListener implements DummyListener {

    private final GraphicalAgent graphicalAgent;
    private final int playerNumber;

    public DiceMouseListener(GraphicalAgent graphicalAgent, int playerNumber) {
        this.graphicalAgent = graphicalAgent;
        this.playerNumber = playerNumber;
    }

    /**
     * TO DO ...
     * <p>
     * when user click the dice label ,
     * send a request to the logic to roll the dice for him
     */

    @Override
    public void mousePressed(MouseEvent e) {
        graphicalAgent.diceRequest(playerNumber);
    }
}
