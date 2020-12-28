package ir.sharif.math.bp99_1.snake_and_ladder.logic;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;
import ir.sharif.math.bp99_1.snake_and_ladder.model.GameState;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;
import ir.sharif.math.bp99_1.snake_and_ladder.model.pieces.Piece;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

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
        int diceNumber = player.getDice().roll();
        player.setMoveLeft(diceNumber);
        player.setDicePlayedThisTurn(true);
        if (diceNumber >= 6)
            player.applyOnScore(1);
        if (!player.hasMove(gameState.getBoard(), diceNumber)) {
            int decreasingScore = 5;
            player.applyOnScore(-decreasingScore);
            gameState.nextTurn();
        }
    }

    public void selectPiece(Piece piece) {
        Player player = gameState.getCurrentPlayer();
        if (!player.isDicePlayedThisTurn())
            return;
        if (!player.equals(piece.getPlayer())) {
            selectCell(piece.getCurrentCell());
            return;
        }
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

    public void selectCell(Cell cell) {
        Player player = gameState.getCurrentPlayer();
        Piece piece = player.getSelectedPiece();
        if (!player.isDicePlayedThisTurn())
            return;
        if (piece == null)
            return;
        if (piece.isValidMove(cell, player.getMoveLeft())) {
            piece.moveTo(cell);
            check(cell, piece);
            gameState.nextTurn();
        }
    }

    private void check(Cell cell, Piece piece) {
        checkPrize(cell, piece);
        checkTransmitter(cell, piece);
        checkSameColor(cell, piece);
    }

    private void checkPrize(Cell cell, Piece piece) {
        if (cell.getPrize() != null)
            cell.getPrize().using(piece);
    }

    private void checkTransmitter(Cell cell, Piece piece) {
        if (cell.getTransmitter() != null)
            cell.getTransmitter().transmit(piece);
    }

    private void checkSameColor(Cell cell, Piece piece) {
        int increasingScore = 2;
        if (cell.getColor().equals(piece.getColor()))
            piece.getPlayer().applyOnScore(increasingScore);
    }

    public void archive(Player player1,Player player2){
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(new File("/src/main/resources/ir/sharif/math/bp99_1/snake_and_ladder/games.archive"),true));
            printStream.println("\n"+player1.getName()+" : "+player1.getScore());
            printStream.println(     player2.getName()+" : "+player2.getScore());
            printStream.flush();
            printStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
