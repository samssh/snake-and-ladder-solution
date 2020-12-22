package ir.sharif.math.bp99_1.snake_and_ladder.graphic;


import ir.sharif.math.bp99_1.snake_and_ladder.logic.LogicalAgent;
import ir.sharif.math.bp99_1.snake_and_ladder.model.GameState;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;

import javax.swing.*;

/**
 * this class is a connection between the graphic and logics
 */
public class GraphicalAgent {
    private final LogicalAgent logicalAgent; // maybe deleted
    private final Object paintLock;

    public GraphicalAgent(LogicalAgent logicalAgent) {
        this.logicalAgent = logicalAgent;
        this.paintLock = new Object();
    }

    /**
     * this method get game state and build or update a graphical models
     * and save this models somewhere
     */
    public void update(GameState gameState) {
        synchronized (paintLock) {
            // update game state
        }
    }

    public void loadFirstPlayer(String name) {

    }

    public void loadSecondPlayer(String name) {

    }

    public void diceRequest(Player p) {

    }

    public void move(Player p, int startX, int startY, int endX, int endY) {

    }

    public Object getPaintLock() {
        return paintLock;
    }

    private String getPlayerNames(int number) {
        String[] s = new String[]{"first", "second"};
        String result;
        do {
            result = JOptionPane.showInputDialog("Enter " + s[number] + " player name ");
        } while (result == null);
        return result;
    }
}
