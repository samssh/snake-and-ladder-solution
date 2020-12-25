package ir.sharif.math.bp99_1.snake_and_ladder.graphic;


import ir.sharif.math.bp99_1.snake_and_ladder.graphic.models.GraphicalGameState;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.BoardPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.MainPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.PlayerInfoPanel;
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
    private GraphicalGameState gameState;
    private Frame frame;

    public GraphicalAgent(LogicalAgent logicalAgent) {
        this.logicalAgent = logicalAgent;
        this.paintLock = new Object();
    }

    /**
     * this method get game state and build or update a graphical models
     * and save this models somewhere
     */
    public void update(GameState gs) {
        synchronized (paintLock) {
            // update game state
        }
    }

    public void initialize(GameState gameState) {
        this.gameState = new GraphicalGameStateBuilder(gameState).build();
        this.frame = initializePanels();
    }

    private Frame initializePanels() {
        PlayerInfoPanel player1Info = new PlayerInfoPanel(gameState.getPlayer1(), this, 1);
        PlayerInfoPanel player2Info = new PlayerInfoPanel(gameState.getPlayer2(), this, 2);
        BoardPanel boardPanel = new BoardPanel(gameState.getBoard(), this);
        MainPanel mainPanel = new MainPanel(boardPanel, player1Info, player2Info);
        return new Frame(mainPanel);
    }

    public void loadFirstPlayer(String name) {

    }

    public void loadSecondPlayer(String name) {

    }

    public void diceRequest(int player) {

    }

    public void clickRequest(int x , int y){

    }

    public void move(Player p, int startX, int startY, int endX, int endY) {

    }

    public Object getPaintLock() {
        return paintLock;
    }

    public String getPlayerNames(int number) {
        String[] s = new String[]{"first", "second"};
        String result;
        do {
            result = JOptionPane.showInputDialog(frame, "Enter " + s[number - 1] + " player name ");
        } while (result == null);
        return result;
    }
}
