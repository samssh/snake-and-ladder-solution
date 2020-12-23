package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Board;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GraphicalBoard extends GraphicalModel {
    private final List<GraphicalCell> graphicalCells;
    private final List<GraphicalTransmitter> graphicalTransmitters;

    public GraphicalBoard(LinkedList<GraphicalCell> gc, LinkedList<GraphicalTransmitter> gtl) {
//        graphicalCells = new GraphicalCell[7][16]; // must be fix this numbers
//        graphicalTransmitters = new LinkedList<>();

        graphicalCells = gc;
        graphicalTransmitters = gtl;
    }


    private void initialize(Board b) {

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
//        for (GraphicalCell[] graphicalCell : graphicalCells) {
//            for (GraphicalCell cell : graphicalCell) {
//                cell.paint(graphics2D);
//            }
//        }
        graphicalTransmitters.forEach(gt -> gt.paint(graphics2D));
    }
}
