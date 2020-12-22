package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Color;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;

import java.awt.*;

public class GraphicalPiece extends GraphicalModel{
    private final String name;
    private GraphicalCell currentGraphicalCell;
    private final Color color;
    private final Player player;

    public GraphicalPiece(Player player, String name, GraphicalCell currentGraphicalCell, Color color){
        this.player = player;
        this.name = name;
        this.currentGraphicalCell = currentGraphicalCell;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return player;
    }

    public Color getColor() {
        return color;
    }

    public GraphicalCell getCurrentCell() {
        return currentGraphicalCell;
    }

    public void setCurrentCell(GraphicalCell currentGraphicalCell) {
        this.currentGraphicalCell = currentGraphicalCell;
    }

    @Override
    public void paint(Graphics2D graphics2D) {

    }
}
