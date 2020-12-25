package ir.sharif.math.bp99_1.snake_and_ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int point;
    private List<Piece> pieces;
    private Dice dice;
    private Player rival;
    private int id;

    public Player(int id, String name, List<Piece> pieces, Dice dice, int point) {
        this.id = id;
        this.dice = dice;
        this.name = name;
        this.pieces = pieces;
        this.point = point;
    }

    public Player(int id, String name, int point) {
        this.id = id;
        this.name = name;
        this.point = point;

        dice = new Dice();

        pieces = new ArrayList<>();

        pieces.add(new Piece(this, Color.RED));
        pieces.add(new Piece(this, Color.BLUE));
        pieces.add(new Piece(this, Color.GREEN));
        pieces.add(new Piece(this, Color.YELLOW));
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

    public int getPoint() {
        return point;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public Player getRival() {
        return rival;
    }

    public void setRival(Player rival) {
        this.rival = rival;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void usePrize(Prize prize) {
        point += prize.getPoint();
        dice.addChance(prize.getChance(), prize.getChanceNumber());
    }

    @Override
    public String toString() {
        return "PlayerID : " + id + '\n' +
                "PlayerName : " + name + '\n' +
                "PlayerScore : " + point + '\n';
    }
}

