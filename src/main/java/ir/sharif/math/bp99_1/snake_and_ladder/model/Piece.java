package ir.sharif.math.bp99_1.snake_and_ladder.model;

public class Piece {
    private String name;
    private Cell currentCell;
    private Color color;

    public Piece(String name,Cell currentCell,Color color){
        this.name = name;
        this.currentCell = currentCell;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }
}
