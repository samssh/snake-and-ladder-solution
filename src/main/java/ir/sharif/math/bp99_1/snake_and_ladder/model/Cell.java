package ir.sharif.math.bp99_1.snake_and_ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final Color color;
    private final List<Cell> adjacentCells;
    private final List<Cell> adjacentOpenCells;
    private final boolean locked;
    private Prize prize;
    private Transmitter transmitter;
    private final int x, y;
    private Piece piece;

    public Cell(Color color, int x, int y) {
        this.color = color;
        this.locked = color == Color.BLACK;
        this.x = x;
        this.y = y;
        transmitter = null;
        prize = null;
        adjacentOpenCells = new ArrayList<>();
        adjacentCells = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public List<Cell> getAdjacentCells() {
        return adjacentCells;
    }

    public List<Cell> getAdjacentOpenCells() {
        return adjacentOpenCells;
    }

    public Piece getPiece() {
        return piece;
    }

    public Prize getPrize() {
        return prize;
    }

    public Transmitter getTransmitter() {
        return transmitter;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean canEnter(Piece piece) {
        return (this.piece == null) && (color.equals(piece.getColor()));
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    public void setTransmitter(Transmitter transmitter) {
        this.transmitter = transmitter;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "color=" + color +
                ", X=" + x +
                ", Y=" + y +
                '}';
    }
}
