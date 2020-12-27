package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalPiece extends GraphicalModel {
    private final GraphicalColor color;
    private final BufferedImage image;
    private final boolean isSelected;

    public GraphicalPiece(GraphicalColor color, boolean isSelected) {
        this.color = color;
        image = ImageLoader.getImage(color.toString().toLowerCase());
        this.isSelected = isSelected;
    }

    public GraphicalColor getColor() {
        return color;
    }

    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphics2D.drawImage(image, 0, 0, GraphicalCell.CELL_SIZE, GraphicalCell.CELL_SIZE, null);
        if (isSelected){
            Stroke stroke = graphics2D.getStroke();
            graphics2D.setStroke(new BasicStroke(5));
            graphics2D.setColor(Color.MAGENTA);
            graphics2D.drawRect(0, 0, GraphicalCell.CELL_SIZE, GraphicalCell.CELL_SIZE);
            graphics2D.setColor(Color.BLACK);
            graphics2D.setStroke(stroke);
        }
    }
}
