package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalTransmitter extends GraphicalModel {
    private final GraphicalCell firstCell,lastCell;
    private final String name;
    private final BufferedImage imagel;

    public GraphicalTransmitter(GraphicalCell firstCell, GraphicalCell lastCell, String name, BufferedImage imagel) {
        this.firstCell = firstCell;
        this.lastCell = lastCell;
        this.name = name;
        this.imagel = imagel;
    }

    @Override
    public void paint(Graphics2D graphics2D) {

    }
}
