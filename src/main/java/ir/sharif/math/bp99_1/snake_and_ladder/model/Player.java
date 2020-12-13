package ir.sharif.math.bp99_1.snake_and_ladder.model;

import java.util.List;

public class Player {
    private String name;
    private int point;
    private List<Piece> pieces;
    private Dice dice;

    public Player(String name,List<Piece> pieces,Dice dice,int point){
        this.dice = dice;
        this.name = name;
        this.pieces = pieces;
        this.point = point;
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
}

