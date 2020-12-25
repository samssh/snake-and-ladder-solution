package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import java.awt.*;

public enum GraphicalColor {
    WHITE(Color.white),
    BLACK(Color.LIGHT_GRAY),
    RED(Color.PINK),
    BLUE(Color.cyan),
    GREEN(Color.green.brighter()),
    YELLOW(Color.yellow.brighter());

    private Color color;

    GraphicalColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
