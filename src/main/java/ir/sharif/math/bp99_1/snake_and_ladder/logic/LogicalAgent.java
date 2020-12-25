package ir.sharif.math.bp99_1.snake_and_ladder.logic;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.GraphicalAgent;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Board;
import ir.sharif.math.bp99_1.snake_and_ladder.model.GameState;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;

public class LogicalAgent {
    private final ModelLoader modelLoader;
    private final GraphicalAgent graphicalAgent;
    private final GameState gameState;

    public LogicalAgent() {
        this.graphicalAgent = new GraphicalAgent(this);
        this.modelLoader = new ModelLoader();
        this.gameState = loadGameState();
    }

    private GameState loadGameState() {
        Board board = modelLoader.loadBord();
        Player player1 = modelLoader.loadPlayer(graphicalAgent.getPlayerNames(1));
        Player player2 = modelLoader.loadPlayer(graphicalAgent.getPlayerNames(2));
        return new GameState(board, player1, player2);
    }

    public void startGame() {
        graphicalAgent.initialize(gameState);
    }
}
