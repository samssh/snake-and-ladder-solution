package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Color;

import java.awt.*;

public class GraphicalCell extends GraphicalModel {
    private final Color color;
    private final GraphicalPrize graphicalPrize;
    private GraphicalPiece graphicalPiece;

    public GraphicalCell(Color color, GraphicalPrize graphicalPrize, GraphicalPiece graphicalPiece) {
        this.color = color;
        this.graphicalPrize = graphicalPrize;
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
        // paint this

        if (graphicalPrize != null) graphicalPrize.paint(graphics2D);
        if (graphicalPiece != null) graphicalPiece.paint(graphics2D);

    }
}
