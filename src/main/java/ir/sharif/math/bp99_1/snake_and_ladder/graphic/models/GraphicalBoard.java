package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GraphicalBoard extends GraphicalModel {
    private final GraphicalCell[][] graphicalCells;
    private final List<GraphicalTransmitter> graphicalTransmitters;

    public GraphicalBoard() {
        graphicalCells = new GraphicalCell[10][10]; // must be fix this numbers
        graphicalTransmitters = new LinkedList<>();
    }

    public GraphicalCell[][] getCells() {
        return graphicalCells;
    }

    public List<GraphicalTransmitter> getTransmitter() {
        return graphicalTransmitters;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        for (GraphicalCell[] graphicalCell : graphicalCells) {
            for (GraphicalCell cell : graphicalCell) {
                cell.paint(graphics2D);
            }
        }
        graphicalTransmitters.forEach(gt -> gt.paint(graphics2D));
    }
}
