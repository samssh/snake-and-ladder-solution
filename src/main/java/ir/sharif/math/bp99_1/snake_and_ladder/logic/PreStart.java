package ir.sharif.math.bp99_1.snake_and_ladder.logic;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Color;
import ir.sharif.math.bp99_1.snake_and_ladder.model.GameState;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;
import ir.sharif.math.bp99_1.snake_and_ladder.model.pieces.Piece;

import java.util.Map;
import java.util.NoSuchElementException;

// //
public class PreStart {
    private final GameState gameState;

    public PreStart(GameState gameState) {
        this.gameState = gameState;
    }


    // //
    public void playerReady(int playerNumber) {
        Player player = gameState.getPlayer(playerNumber);
        player.setReady(!player.isReady());
        if (player.isReady() && player.getRival().isReady()) {
            prepareGameStat();
        }
    }

    // *
    private void prepareGameStat() {
        for (Map.Entry<Cell, Integer> entry : gameState.getBoard().getStartingCells().entrySet()) {
            Cell cell = entry.getKey();
            int playerNumber = entry.getValue();
            Player player = gameState.getPlayer(playerNumber);
            Piece piece = findPiece(player, cell.getColor());
            cell.setPiece(piece);
            piece.setCurrentCell(cell);
        }
        gameState.start();
    }

    // *
    private Piece findPiece(Player player, Color color) {
        for (Piece piece : player.getPieces())
            if (piece.getColor().equals(color))
                return piece;
        throw new NoSuchElementException();
    }
}
