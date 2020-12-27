package ir.sharif.math.bp99_1.snake_and_ladder.logic;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;
import ir.sharif.math.bp99_1.snake_and_ladder.model.GameState;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;
import ir.sharif.math.bp99_1.snake_and_ladder.model.pieces.Piece;

public class Game {
    private final GameState gameState;

    public Game(GameState gameState) {
        this.gameState = gameState;
    }

    public void rollDice(int playerNumber) {
        Player player = gameState.getPlayer(playerNumber);
        if (!player.equals(gameState.getCurrentPlayer()))
            return;
        if (player.isDicePlayedThisTurn())
            return;
        int result = player.getDice().roll();
        player.setMoveLeft(result);
        player.setDicePlayedThisTurn(true);
        // todo check have move
    }

    public void selectPiece(Piece piece) {
        Player player = gameState.getCurrentPlayer();
        if (!player.isDicePlayedThisTurn())
            return;
        if (!player.equals(piece.getPlayer()))
            return;
        if (piece.isSelected()) {
            piece.setSelected(false);
            player.setSelectedPiece(null);
        } else {
            piece.setSelected(true);
            if (player.getSelectedPiece() != null)
                player.getSelectedPiece().setSelected(false);
            player.setSelectedPiece(piece);
        }
    }

    public void selectEmptyCell(Cell cell) {
        Player player = gameState.getCurrentPlayer();
        Piece piece = player.getSelectedPiece();
        if (!player.isDicePlayedThisTurn())
            return;
        if (piece == null)
            return;
        if (piece.isValidMove(cell, player.getMoveLeft())) {
            piece.moveTo(cell);
            piece.setSelected(false);
            player.endTurn();
            gameState.nextTurn();
            // todo check prize and snakes
        }
    }


}
