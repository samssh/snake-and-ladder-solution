package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Color;

import java.awt.*;
import java.util.List;

public class GraphicalCell extends GraphicalModel{
    private final Color color;
    private final GraphicalPrize graphicalPrize;
//    private final Transmitter transmitter;
    private GraphicalPiece graphicalPiece;

    public GraphicalCell(Color color, GraphicalPrize graphicalPrize, GraphicalPiece graphicalPiece){
        this.color = color;
        this.graphicalPrize = graphicalPrize;
//        this.transmitter = transmitter;
        this.graphicalPiece = graphicalPiece;
    }

    public Color getColor() {
        return color;
    }

    public GraphicalPiece getPiece() {
        return graphicalPiece;
    }

    public GraphicalPrize getPrize() {
        return graphicalPrize;
    }

    public void setPiece(GraphicalPiece graphicalPiece) {
        this.graphicalPiece = graphicalPiece;
    }

    @Override
    public void paint(Graphics2D graphics2D) {

    }
}
