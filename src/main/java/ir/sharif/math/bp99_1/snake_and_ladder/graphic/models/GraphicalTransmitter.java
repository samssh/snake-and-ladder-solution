package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.ImageLoader;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalTransmitter extends GraphicalModel {
    private Snake s;
//    public GraphicalTransmitter(GraphicalCell firstCell, GraphicalCell lastCell, String name) {
//        this.firstCell = firstCell;
//        this.lastCell = lastCell;
//        this.name = name;
//        image = ImageLoader.getImage(name);
//    }


    public GraphicalTransmitter(Snake s) {
        this.s = s;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        s.paint(graphics2D);
    }
}
