package ir.sharif.math.bp99_1.snake_and_ladder.model;

public class Piece {
    private Cell currentCell;
    private final Color color;
    private final Player player;
    private boolean isSelected;

    public Piece(Player player, Color color) {
        this.player = player;
        this.color = color;
        this.isSelected = false;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }
}
