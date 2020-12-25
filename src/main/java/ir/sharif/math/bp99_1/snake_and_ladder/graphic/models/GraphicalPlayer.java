package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;


import java.awt.*;
import java.util.List;

public class GraphicalPlayer extends GraphicalModel {
    private String name;
    private int score;
    private final List<GraphicalPiece> pieces;


    public GraphicalPlayer(String name, int score, List<GraphicalPiece> pieces) {
        this.name = name;
        this.score = score;
        this.pieces = pieces;
    }

    public List<GraphicalPiece> getPieces() {
        return pieces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void paint(Graphics2D graphics2D) {

    }
}
