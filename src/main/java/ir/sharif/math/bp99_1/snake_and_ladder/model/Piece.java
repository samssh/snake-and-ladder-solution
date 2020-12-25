package ir.sharif.math.bp99_1.snake_and_ladder.model;

public class Piece {
    private Cell currentCell;
    private final Color color;
    private final Player player;

    public Piece(Player player, Color color) {
        this.player = player;
        this.color = color;
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
