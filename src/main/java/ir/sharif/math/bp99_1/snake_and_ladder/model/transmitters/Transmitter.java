package ir.sharif.math.bp99_1.snake_and_ladder.model.transmitters;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;
import ir.sharif.math.bp99_1.snake_and_ladder.model.pieces.Piece;

public class Transmitter {
    private final Cell firstCell, lastCell;

    public Transmitter(Cell firstCell, Cell lastCell) {
        this.firstCell = firstCell;
        this.lastCell = lastCell;
    }

    public Cell getFirstCell() {
        return firstCell;
    }

    public Cell getLastCell() {
        return lastCell;
    }

    //***
    public void transmit(Piece piece) {
        int negativeScore = 3;
        if (lastCell.getPiece() == null)
            piece.moveTo(lastCell);
        piece.getPlayer().applyOnScore(-negativeScore);
    }

    @Override
    public String toString() {
        return "Transmitter{" +
                "firstCell=" + firstCell +
                ", lastCell=" + lastCell +
                '}';
    }
}
