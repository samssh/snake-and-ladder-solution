package ir.sharif.math.bp99_1.snake_and_ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cell {
    private final Color color;
    private final boolean locked;
    private final int x, y;
    private Transmitter transmitter;
    private Prize prize;
    private Piece piece;
    private final List<Cell> adjacentOpenCells;
    private final List<Cell> adjacentCells;

    public Cell(Color color, int x, int y) {
        this.color = color;
        this.locked = color == Color.BLACK;
        this.x = x;
        this.y = y;
        this.transmitter = null;
        this.prize = null;
        this.piece = null;
        this.adjacentOpenCells = new ArrayList<>();
        this.adjacentCells = new ArrayList<>();
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
        return (this.piece == null) && (color.equals(piece.getColor()) || color.equals(Color.WHITE));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
