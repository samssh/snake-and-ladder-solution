package ir.sharif.math.bp99_1.snake_and_ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private String name;
    private int score;
    private final List<Piece> pieces;
    private final Dice dice;
    private Player rival;
    private final int id;
    private boolean isReady;
    private int moveLeft;

    public Player(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.dice = new Dice();
        this.pieces = new ArrayList<>();
        this.pieces.add(new Piece(this, Color.RED));
        this.pieces.add(new Piece(this, Color.BLUE));
        this.pieces.add(new Piece(this, Color.GREEN));
        this.pieces.add(new Piece(this, Color.YELLOW));
        this.moveLeft = 0;
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

    public Player getRival() {
        return rival;
    }

    public int getMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(int moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setRival(Player rival) {
        this.rival = rival;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void usePrize(Prize prize) {
        score += prize.getPoint();
        dice.addChance(prize.getChance(), prize.getChanceNumber());
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

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

