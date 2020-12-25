package ir.sharif.math.bp99_1.snake_and_ladder.model;

import ir.sharif.math.bp99_1.snake_and_ladder.util.ThreadColor;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Board {
    private final List<Cell> cells;
    private final List<Transmitter> transmitters;
    private final List<Wall> walls;
    private final List<Cell> startingCells;

    public Board(){
        cells = new LinkedList<>();
        transmitters = new LinkedList<>();
        walls = new LinkedList<>();
        startingCells = new LinkedList<>();
    }

    public List<Cell> getCells() {
        return cells;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Cell> getStartingCells() {
        return startingCells;
    }

    public List<Transmitter> getTransmitter() {
        return transmitters;
    }

    public Cell getCell(int X, int Y){
        System.out.println(ThreadColor.ANSI_CYAN + cells.toString() + ThreadColor.ANSI_RESET);
        for(Cell cell : cells){
            if(cell.getX() == X && cell.getY() == Y)
                return cell;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Board{" +
                ", transmitters=" + transmitters +
                '}';
    }
}
