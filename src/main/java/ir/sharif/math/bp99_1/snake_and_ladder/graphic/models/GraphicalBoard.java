package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import java.awt.*;
import java.util.List;

public class GraphicalBoard extends GraphicalModel{
    private List<GraphicalCell> graphicalCells;
    private List<GraphicalTransmitter> graphicalTransmitter;

    public GraphicalBoard(){

    }

    public List<GraphicalCell> getCells() {
        return graphicalCells;
    }

    public List<GraphicalTransmitter> getTransmitter() {
        return graphicalTransmitter;
    }

    public void setTransmitter(List<GraphicalTransmitter> graphicalTransmitter) {
        this.graphicalTransmitter = graphicalTransmitter;
    }

    public void setCells(List<GraphicalCell> graphicalCells) {
        this.graphicalCells = graphicalCells;
    }

    @Override
    public void paint(Graphics2D graphics2D) {

    }
}
