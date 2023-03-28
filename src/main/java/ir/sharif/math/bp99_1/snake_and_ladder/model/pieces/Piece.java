package main.java.ir.sharif.math.bp99_1.snake_and_ladder.model.pieces;

import main.java.ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;
import main.java.ir.sharif.math.bp99_1.snake_and_ladder.model.Color;
import main.java.ir.sharif.math.bp99_1.snake_and_ladder.model.Player;

public class Piece {
    private Cell currentCell;
    private final Color color;
    private final Player player;
    private boolean isSelected;

    public Piece(Player player, Color color) {
        this.color = color;
        this.player = player;
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

    public boolean isValidMove(Cell destination, int diceNumber) {
        int dx = Integer.compare(destination.getX() - currentCell.getX(), 0);
        int dy = Integer.compare(destination.getY() - currentCell.getY(), 0);
        if (dx != 0 && dy != 0)
            return false;
        int dist = Math.abs(destination.getX() - currentCell.getX()) + Math.abs(destination.getY() - currentCell.getY());
        if (dist != diceNumber)
            return false;
        if (!destination.canEnter(this))
            return false;
        Cell neighbor = this.currentCell;
        for (int i = 0; i < diceNumber; i++) {
            neighbor = neighbor.getOpenNeighbor(dx, dy);
            if (neighbor == null)
                return false;
        }
        return destination.getPiece() == null;
    }

    public void moveTo(Cell destination) {
        currentCell.setPiece(null);
        destination.setPiece(this);
        currentCell = destination;
    }
}
