package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Color;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;

import java.awt.*;

public class GraphicalPiece extends GraphicalModel{
    private final Color color;

    public GraphicalPiece( Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }


    @Override
    public void paint(Graphics2D graphics2D) {

    }
}
