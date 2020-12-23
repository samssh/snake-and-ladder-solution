package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Color;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;

import java.awt.*;

public class GraphicalPiece extends GraphicalModel{
    private final String name;
    private final Color color;

    public GraphicalPiece( String name, Color color){
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }


    public Color getColor() {
        return color;
    }


    @Override
    public void paint(Graphics2D graphics2D) {

    }
}
