package ir.sharif.math.bp99_1.snake_and_ladder.model;

public class Transmitter {
    private Cell firstCell,lastCell;

    public Transmitter(Cell firstCell,Cell lastCell){
        this.firstCell = firstCell;
        this.lastCell = lastCell;
    }

    public Cell getFirstCell() {
        return firstCell;
    }

    public Cell getLastCell() {
        return lastCell;
    }

    public void transmit(Piece piece){
        // Your Code
    }
}
