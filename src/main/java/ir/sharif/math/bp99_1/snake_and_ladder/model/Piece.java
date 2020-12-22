package ir.sharif.math.bp99_1.snake_and_ladder.model;

public class Piece {
    private final String name;
    private Cell currentCell;
    private final Color color;
    private final Player player;

    public Piece(Player player,String name,Cell currentCell,Color color){
        this.player = player;
        this.name = name;
        this.currentCell = currentCell;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return player;
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
