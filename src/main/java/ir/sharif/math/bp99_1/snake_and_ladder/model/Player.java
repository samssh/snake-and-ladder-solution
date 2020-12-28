package ir.sharif.math.bp99_1.snake_and_ladder.model;

import ir.sharif.math.bp99_1.snake_and_ladder.model.pieces.Piece;
import ir.sharif.math.bp99_1.snake_and_ladder.model.prizes.Prize;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private final String name;
    private int score;
    private final List<Piece> pieces;
    private final Dice dice;
    private Player rival;
    private final int id;
    private int playerNumber;
    private boolean isReady;
    private boolean dicePlayedThisTurn;
    private int moveLeft;
    private Piece selectedPiece;

    public Player(String name, int score, int id, int playerNumber) {
        this.name = name;
        this.score = score;
        this.id = id;
        this.playerNumber = playerNumber;
        this.dice = new Dice();
        this.pieces = new ArrayList<>();
        this.pieces.add(new Piece(this, Color.RED));
        this.pieces.add(new Piece(this, Color.BLUE));
        this.pieces.add(new Piece(this, Color.GREEN));
        this.pieces.add(new Piece(this, Color.YELLOW));
        this.moveLeft = 0;
        this.selectedPiece = null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Dice getDice() {
        return dice;
    }

    public int getScore() {
        return score;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Player getRival() {
        return rival;
    }

    public int getMoveLeft() {
        return moveLeft;
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    public boolean isDicePlayedThisTurn() {
        return dicePlayedThisTurn;
    }

    public void setDicePlayedThisTurn(boolean dicePlayedThisTurn) {
        this.dicePlayedThisTurn = dicePlayedThisTurn;
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    public void setMoveLeft(int moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setRival(Player rival) {
        this.rival = rival;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void applyOnScore(int score) {
        this.score += score;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    //***
    public void usePrize(Prize prize) {
        score += prize.getPoint();
        dice.addChance(prize.getChance(), prize.getChanceNumber());
    }

    //***
    public boolean hasMove(Board board, int diceNumber) {
        for (Piece piece : pieces) {
            for (Cell cell : board.getCells()) {
                if (piece.isValidMove(cell, diceNumber))
                    return true;
            }
        }
        return false;
    }

    public void endTurn() {
        if (selectedPiece != null)
            selectedPiece.setSelected(false);
        selectedPiece = null;
        moveLeft = 0;
        dicePlayedThisTurn = false;
    }


    // dont touch it
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PlayerID : " + id + '\n' +
                "PlayerName : " + name + '\n' +
                "PlayerScore : " + score + '\n';
    }
}

