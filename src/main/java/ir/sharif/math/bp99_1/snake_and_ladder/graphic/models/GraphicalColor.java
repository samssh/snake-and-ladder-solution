package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import java.awt.*;

public enum GraphicalColor {
    WHITE(Color.white),
    BLACK(Color.LIGHT_GRAY),
    RED(new Color(252, 163, 163, 255)),
    BLUE(new Color(122, 246, 225)),
    GREEN(new Color(122, 241, 93)),
    YELLOW(new Color(255, 229, 119));

    private final Color color;

    GraphicalColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
