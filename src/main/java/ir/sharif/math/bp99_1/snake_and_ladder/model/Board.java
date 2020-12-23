package ir.sharif.math.bp99_1.snake_and_ladder.model;

import java.util.List;

public class Board {
    private Cell[][] cells;
    private List<Transmitter> transmitter;

    public Board(){

    }

    public List<Transmitter> getTransmitter() {
        return transmitter;
    }

    public void setTransmitter(List<Transmitter> transmitter) {
        this.transmitter = transmitter;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
