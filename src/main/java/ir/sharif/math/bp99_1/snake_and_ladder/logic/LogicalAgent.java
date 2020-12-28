package ir.sharif.math.bp99_1.snake_and_ladder.logic;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.GraphicalAgent;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Board;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;
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
        Player player1 = modelLoader.loadPlayer(graphicalAgent.getPlayerNames(1) , 1);
        Player player2;
        do {
            player2 = modelLoader.loadPlayer(graphicalAgent.getPlayerNames(2),2);
        } while (player1.equals(player2));
        player1.setRival(player2);
        player2.setRival(player1);
        return new GameState(board, player1, player2);
    }

    public void initialize() {
        graphicalAgent.initialize(gameState);
    }

    // ***
    public void readyPlayer(int playerNumber) {
        if (!gameState.isStarted())
            preStart.playerReady(playerNumber);


        // dont touch it
        graphicalAgent.update(gameState);
    }

    // ***
    public void selectPiece(int x, int y) {
        if (gameState.isStarted()) {
            Cell cell = gameState.getBoard().getCell(x, y);
            if (cell.getPiece() != null) game.selectPiece(cell.getPiece());
            else game.selectCell(cell);
            graphicalAgent.update(gameState);
            checkForEndGame();
        }
    }

    // ***
    public void rollDice(int playerNumber) {
        if (gameState.isStarted()) {
            game.rollDice(playerNumber);
            graphicalAgent.update(gameState);
            checkForEndGame();
        }
    }

    //***
    private void checkForEndGame() {
        if (gameState.getTurn() > 30) {
            // game ends
            int winner;
            if (gameState.getPlayer1().getScore() > gameState.getPlayer2().getScore()) {
                winner = 1;
            } else if (gameState.getPlayer1().getScore() < gameState.getPlayer2().getScore()) {
                winner = 2;
            } else winner = 3;
            graphicalAgent.playerWin(winner);
            /* save players*/
            modelLoader.savePlayer(gameState.getPlayer1());
            modelLoader.savePlayer(gameState.getPlayer2());
            modelLoader.archive(gameState.getPlayer1(), gameState.getPlayer2());
            LogicalAgent logicalAgent = new LogicalAgent();
            logicalAgent.initialize();
        }
    }

    //***
    public String getDiceDetail(int playerNumber) {
        return gameState.getPlayer(playerNumber).getDice().getDetails();
    }
}
