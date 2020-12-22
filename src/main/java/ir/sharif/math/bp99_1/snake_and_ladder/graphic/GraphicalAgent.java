package ir.sharif.math.bp99_1.snake_and_ladder.graphic;


import ir.sharif.math.bp99_1.snake_and_ladder.logic.LogicalAgent;
import ir.sharif.math.bp99_1.snake_and_ladder.model.GameState;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;

/**
 * this class is a connection between the graphic and logics
 */
public class GraphicalAgent {

    private static GraphicalAgent graphicalAgent;
    private LogicalAgent logicalAgent;
    private GraphicalAgent() {
    }

    public GraphicalAgent(LogicalAgent logicalAgent) {
        this.logicalAgent = logicalAgent;
    }

    public static GraphicalAgent getInstance() {
        if (graphicalAgent == null)
            graphicalAgent = new GraphicalAgent();
        return graphicalAgent;
    }

    public void setLogicalAgent(LogicalAgent logicalAgent) {
        this.logicalAgent = logicalAgent;
    }

    /**
     * this method get game state and build or update a graphical models
     * and save this models somewhere
     */
    public void update(GameState gameState) {
        throw new RuntimeException("implement me");
    }

    public void loadFirstPlayer(String name) {

    }

    public void loadSecondPlayer(String name) {

    }

    public void diceRequest(Player p) {

    }

    public void move(Player p, int startX, int startY, int endX, int endY) {

    }
}
