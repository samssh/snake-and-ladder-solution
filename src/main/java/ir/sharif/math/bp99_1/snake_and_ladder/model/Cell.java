package ir.sharif.math.bp99_1.snake_and_ladder.model;

import java.util.List;

public class Cell {
    private final Color color;
    private final List<Cell> adjacentCells;
    private final List<Cell> adjacentOpenCells;
    private final boolean locked;
    private final Prize prize;
    private final Transmitter transmitter;
    private Piece piece;

    public Cell(Color color,List<Cell> adjacentCells,List<Cell> adjacentOpenCells,boolean locked,Prize prize,Transmitter transmitter,Piece piece){
        this.color = color;
        this.adjacentCells = adjacentCells;
        this.adjacentOpenCells = adjacentOpenCells;
        this.locked = locked;
        this.prize = prize;
        this.transmitter = transmitter;
        this.piece = piece;
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

    public boolean canEnter(Piece piece){
        return (this.piece==null) && (color.equals(piece.getColor()));
    }

}
