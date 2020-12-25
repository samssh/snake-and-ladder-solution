package ir.sharif.math.bp99_1.snake_and_ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final Color color;
    private List<Cell> adjacentCells;
    private List<Cell> adjacentOpenCells;
    private final boolean locked;
    private Prize prize;
    private Transmitter transmitter;
    private final int X, Y;
    private Piece piece;

    public Cell(Color color, int X, int Y) {
        this.color = color;
        this.locked = color == Color.BLACK;
        this.X = X;
        this.Y = Y;

        transmitter = null;
        prize = null;
        adjacentOpenCells = new ArrayList<>();
        adjacentCells = new ArrayList<>();
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
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
                ", X=" + X +
                ", Y=" + Y +
                '}';
    }
}
