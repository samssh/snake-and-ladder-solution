package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalPiece extends GraphicalModel {
    private final GraphicalColor color;
    private BufferedImage image;

    public GraphicalPiece(GraphicalColor color) {
        this.color = color;
        System.out.println(color.toString().toLowerCase());
        image = ImageLoader.getImage(color.toString().toLowerCase());
    }

    public GraphicalColor getColor() {
        return color;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphics2D.drawImage(image, 0, 0, 80, 80, null);
    }
}
