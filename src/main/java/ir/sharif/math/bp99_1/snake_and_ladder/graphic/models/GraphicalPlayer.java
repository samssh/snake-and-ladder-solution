package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Piece;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;

import java.awt.*;
import java.util.ArrayList;

public class GraphicalPlayer extends GraphicalModel{
    private String name;
    private int score;
    private ArrayList<GraphicalPiece> pieces;
//    public GraphicalPlayer(String name, int score, ArrayList<Piece> pieces) {
//        this.name = name;
//        this.score = score;
//        initialPiece(pieces);
//    }

    public GraphicalPlayer(String name, int score, ArrayList<GraphicalPiece> pieces) {
        this.name = name;
        this.score = score;
        this.pieces = pieces;
    }

//    public GraphicalPlayer(Player p){
//        name = p.getName();
//        score = p.getPoint();
//        initialPiece((ArrayList<Piece>) p.getPieces());
//    }


    private void initialPiece(ArrayList<Piece> pieces){
        this.pieces=new ArrayList<>();
        for (Piece a:pieces) {
            this.pieces.add(new GraphicalPiece(a.getPlayer(),a.getName(),a.getColor()));
        }
    }

    public ArrayList<GraphicalPiece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<GraphicalPiece> pieces) {
        this.pieces = pieces;
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
