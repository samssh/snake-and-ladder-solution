package ir.sharif.math.bp99_1.snake_and_ladder.logic;

import ir.sharif.math.bp99_1.snake_and_ladder.model.*;

import java.util.Map;
import java.util.NoSuchElementException;

public class PreStart {
    private final GameState gameState;

    public PreStart(GameState gameState) {
        this.gameState = gameState;
    }


    public void playerReady(int playerNumber) {
        Player player = gameState.getPlayer(playerNumber);
        player.setReady(!player.isReady());
        if (player.isReady() && player.getRival().isReady()) {
            prepareGameStat();
        }
    }

    private void prepareGameStat() {
        for (Map.Entry<Cell, Integer> entry : gameState.getBoard().getStartingCells().entrySet()) {
            Player player = gameState.getPlayer(entry.getValue());
            Piece piece = findPiece(player, entry.getKey().getColor());
            entry.getKey().setPiece(piece);
        }
        gameState.start();
    }

    private Piece findPiece(Player player, Color color) {
        for (Piece piece : player.getPieces())
            if (piece.getColor().equals(color))
                return piece;
        throw new NoSuchElementException();
    }
}
