package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Board;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GraphicalBoard extends GraphicalModel {
    private final List<GraphicalCell> graphicalCells;
    private final List<GraphicalTransmitter> graphicalTransmitters;
    private final List<GraphicalWall> graphicalWalls;

    public GraphicalBoard(LinkedList<GraphicalCell> graphicalCells, LinkedList<GraphicalTransmitter> graphicalTransmitters, LinkedList<GraphicalWall> graphicalWalls) {
        this.graphicalCells = graphicalCells;
        this.graphicalTransmitters = graphicalTransmitters;
        this.graphicalWalls = graphicalWalls;
    }

    public List<GraphicalWall> getGraphicalWalls() {
        return graphicalWalls;
    }

    public List<GraphicalCell> getGraphicalCells() {
        return graphicalCells;
    }

    public List<GraphicalTransmitter> getGraphicalTransmitters() {
        return graphicalTransmitters;
    }

    public List<GraphicalTransmitter> getTransmitter() {
        return graphicalTransmitters;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphicalCells.forEach(gt -> gt.paint(graphics2D));
        graphicalWalls.forEach(gt ->gt.paint(graphics2D));
        graphicalTransmitters.forEach(gt -> gt.paint(graphics2D));
    }
}
