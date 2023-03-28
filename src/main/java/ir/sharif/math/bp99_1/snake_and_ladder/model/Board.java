package main.java.ir.sharif.math.bp99_1.snake_and_ladder.model;

import main.java.ir.sharif.math.bp99_1.snake_and_ladder.model.transmitters.Transmitter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Board {
    private final List<Cell> cells;
    private final List<Transmitter> transmitters;
    private final List<Wall> walls;
    private final Map<Cell, Integer> startingCells;

    public Board() {
        cells = new LinkedList<>();
        transmitters = new LinkedList<>();
        walls = new LinkedList<>();
        startingCells = new HashMap<>();
    }

    public List<Cell> getCells() {
        return cells;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public Map<Cell, Integer> getStartingCells() {
        return startingCells;
    }

    public List<Transmitter> getTransmitters() {
        return transmitters;
    }

    public Cell getCell(int x, int y) {
        for (Cell cell : cells) {
            if (cell.getX() == x && cell.getY() == y)
                return cell;
        }
        throw new RuntimeException();
    }

    @Override
    public String toString() {
        return "Board{" +
                ", transmitters=" + transmitters +
                '}';
    }
}
